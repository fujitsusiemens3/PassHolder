package com.rafal.controller

import com.rafal.PASSWORD
import com.rafal.database.DataRepository
import com.rafal.view.MainView
import com.rafal.view.SecureView
import com.rafal.view.UnauthorizedTabView
import tornadofx.*

class LoginController: Controller() {
    private val unauthorizedTabView: UnauthorizedTabView by inject()
    private val secureView: SecureView by inject()
    private val repo = DataRepository()

    fun init() {
        primaryStage.uiComponent<UIComponent>()?.replaceWith(MainView::class, sizeToScene = true, centerOnScreen = true)
    }

    private fun showLoginScreen() {
        secureView.replaceWith(unauthorizedTabView, sizeToScene = true, centerOnScreen = true)
    }

    private fun showSecureScreen() {
        unauthorizedTabView.replaceWith(secureView, sizeToScene = true, centerOnScreen = true)
    }

    fun tryLogin(key: String): Boolean {
        if (key.isNotEmpty()) {
            val savedPassword = repo.fetchMasterPassword()
            if (savedPassword == key) {
                showSecureScreen()
                return true
            }
        }
        return false
    }

    fun logout() {
        with(config) {
            remove(PASSWORD)
            save()
        }
        showLoginScreen()
    }
}
package com.rafal.controller

import com.rafal.PASSWORD
import com.rafal.USERNAME
import com.rafal.view.LoginView
import com.rafal.view.SecureView
import tornadofx.*

class LoginController: Controller() {
    private val loginView: LoginView by inject()
    private val secureView: SecureView by inject()

    fun init() {
        with(config) {
            if (containsKey(USERNAME) && containsKey(PASSWORD)) {
                tryLogin(string(USERNAME), string(PASSWORD))
            } else {
                showLoginScreen("Please log in")
            }
        }
    }

    fun showLoginScreen(message: String, shake: Boolean = false) {
        secureView.replaceWith(loginView, sizeToScene = true, centerOnScreen = true)
        runLater {
            if (shake) {
                loginView.shakeStage()
            }
        }
    }

    fun showSecureScreen() {
        loginView.replaceWith(secureView, sizeToScene = true, centerOnScreen = true)
    }

    fun tryLogin(username: String, password: String): Boolean {
        return true
    }

    fun logout() {
        with(config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }

        showLoginScreen("Please log in")
    }
}
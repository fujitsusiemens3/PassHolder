package com.rafal.app

import com.rafal.controller.LoginController
import com.rafal.view.LoginView
import javafx.stage.Stage
import tornadofx.*

class MyApp: App(LoginView::class, Styles::class) {
    private val loginController: LoginController by inject()

    override fun start(stage: Stage) {
        super.start(stage)
        loginController.init()
    }
}

fun main(args: Array<String>) {
    launch<MyApp>(args)
}
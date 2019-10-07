package com.rafal.view

import com.rafal.controller.LoginController
import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*

class SecureView: View("Secure Screen") {
    val loginController: LoginController by inject()

    override val root = borderpane {
        setPrefSize(800.0, 600.0)

        top {
            label(title) {
                font = Font.font(22.0)
            }
        }

        center {
            vbox(spacing = 15) {
                alignment = Pos.CENTER

                label("Successfully logged id")

                hbox {
                    alignment = Pos.CENTER

                    button("Logout") {
                        setOnAction {
                            loginController.logout()
                        }
                    }

                    button("Exit") {
                        setOnAction {
                            Platform.exit()
                        }
                    }
                }
            }
        }
    }
}
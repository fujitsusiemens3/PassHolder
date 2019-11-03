package com.rafal.view

import com.rafal.app.Styles
import com.rafal.controller.LoginController
import com.rafal.model.UnauthorizedTabModel
import javafx.geometry.Pos
import javafx.scene.control.ButtonBar
import javafx.scene.control.PasswordField
import tornadofx.*

class UnauthorizedTabView : View() {

    private val loginController: LoginController by inject()
    private var password: PasswordField by singleAssign()

    override val root = form {

        vbox(alignment = Pos.CENTER) {

            label(messages["view_label"]) {
                addClass(Styles.heading)
            }

            passwordfield {
                password = this
            }

            button(messages["decrypt_button"]) {
                isDefaultButton = true

                action { loginController.tryLogin(password.text) }
            }
        }
        addClass(Styles.unauthorizedViewStyle)
    }
}
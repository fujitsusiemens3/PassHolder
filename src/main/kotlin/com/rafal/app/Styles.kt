package com.rafal.app

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val loginScreen by cssclass()
    }

    init {
        heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }
        label {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
            alignment = Pos.CENTER
        }
        loginScreen {
            padding = box(15.px)
            vgap = 7.px
            hgap = 10.px
        }
    }
}
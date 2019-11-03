package com.rafal.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val unauthorizedViewStyle by cssclass()
    }

    init {
        heading {
            padding = box(10.px, 5.px, 15.px, 5.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        unauthorizedViewStyle {
            padding = box(15.px)
            vgap = 7.px
            hgap = 10.px
        }
    }
}
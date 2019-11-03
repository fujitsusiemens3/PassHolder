package com.rafal.view

import com.rafal.MIN_HEIGHT
import com.rafal.MIN_WIDTH
import javafx.animation.KeyFrame
import javafx.animation.Timeline
import javafx.event.EventHandler
import javafx.scene.control.TabPane
import javafx.util.Duration
import tornadofx.*

class MainView : View("Passwords Holder") {

    private val encryptedDataTabView: UnauthorizedTabView by inject()

    override val root = tabpane {
        minWidth = MIN_WIDTH
        minHeight = MIN_HEIGHT

        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

        tab(messages["data_tab"]) {
            add(encryptedDataTabView)
        }
        tab(messages["generator_tab"]) {

        }

    }


    fun shakeStage() {
        var x = 0
        var y = 0
        val cycleCount = 10
        val move = 10
        val keyframeDuration = Duration.seconds(0.04)

        val stage = FX.primaryStage


        val timelineX = Timeline(KeyFrame(keyframeDuration, EventHandler {
            if (x == 0) {
                stage.x = stage.x + move
                x = 1
            } else {
                stage.x = stage.x - move
                x = 0
            }
        }))

        timelineX.cycleCount = cycleCount
        timelineX.isAutoReverse = false

        val timelineY = Timeline(KeyFrame(keyframeDuration, EventHandler {
            if (y == 0) {
                stage.y = stage.y + move
                y = 1
            } else {
                stage.y = stage.y - move
                y = 0
            }
        }))

        timelineY.cycleCount = cycleCount
        timelineY.isAutoReverse = false

        timelineX.play()
        timelineY.play()
    }
}
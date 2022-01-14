package com.example.view

import com.example.Styles
import com.example.controller.MainController
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val mainController: MainController by inject()


    override val root = vbox {
        alignment = Pos.CENTER
        spacing=10.0

        label(mainController.labelText){
            bind(mainController.labelText)
            addClass(Styles.heading)
        }

        label(mainController.labelNumber) {
            bind(mainController.labelNumber)
            addClass(Styles.heading)
        }


       button{
           this.text = "Click Me!"
           action {
                mainController.getRandomName()
           }

       }
        listview (mainController.values)


    }

}


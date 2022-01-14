package com.example.controller

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.Controller

class MainController: Controller() {
     var labelText = SimpleStringProperty()
     var labelNumber = SimpleDoubleProperty()
     val myList:List<String> = listOf("Cat", "dog","bird")
     val values = FXCollections.observableArrayList<String>(
        "Alpha",
        "Beta",
        "Gamma",
        "Delta",
    )


    fun getRandomName(){
        val randomInteger: Int = (myList.indices).shuffled().first()
        labelText.set(myList[randomInteger])
    }



}
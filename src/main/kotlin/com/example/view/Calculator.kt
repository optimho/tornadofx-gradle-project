package com.example.view
import com.example.controller.Operator
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.View
import java.awt.event.KeyEvent
import com.example.controller.Operator.*
import javafx.scene.control.Button


class Calculator : View() {
    override val root: VBox by fxml()

    @FXML
    lateinit var display: Label

    init{
        title ="KT_Claculator"
        root.lookupAll(".button").forEach {
            b->b.setOnMouseClicked {
            operator((b as Button).text)
        }
        }

    root.addEventFilter(KeyEvent.KEY_TYPED){
        perator(it.chara)

    }
    }
    var state: Operator = Add(0)
    fun onAction(fn: Operator){
        state =fn
        display.text =""
    }
    val displayValue: Long
    get() = when(display.text){
        ""->0
        else -> display.text.toLong()
    }
    private fun operator(x: String){
    if (Regex("[0-9]").matches(x)){
        display.text +=x
    }else {
        when (x){
            "+" -> onAction(Add(displayValue))
            "-" -> onAction(Sub(displayValue))
            "/" -> onAction(Div(displayValue))
            "%" -> {onAction(Add(displayValue/100)); operator("=")}
            "X" -> onAction(Mul(displayValue))
            "C" -> onAction(Add(0))
            "+/-" -> {onAction(Add(-1*displayValue)); operator("=")}
            "=" -> display.text = state.calculate(displayValue).toString()


        }
     }
  }
}

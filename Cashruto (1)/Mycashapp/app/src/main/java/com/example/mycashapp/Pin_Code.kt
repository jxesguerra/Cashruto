package com.example.mycashapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams
import android.view.KeyEvent
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class Pin_Code : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.pin_code)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.PinLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                0,
                systemBars.right,
                systemBars.bottom)

            val notifBar = findViewById<View>(R.id.notifvar)
            notifBar.updateLayoutParams {
                height = systemBars.top
            }
            insets
        }

        window.navigationBarColor = ContextCompat.getColor(this, R.color.brown)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.isAppearanceLightNavigationBars = false

//        pin layout
        val mainLayout = findViewById<LinearLayout>(R.id.Main_Layout)
        val mpin = findViewById<CardView>(R.id.Mpin_Btn)

        val pin = findViewById<LinearLayout>(R.id.Pin_Layout)

        mpin.setOnClickListener {
            mainLayout.visibility = View.GONE
            pin.visibility = View.VISIBLE
        }

//pin
        val pin1 = findViewById<EditText>(R.id.input1)
        val pin2 = findViewById<EditText>(R.id.input2)
        val pin3 = findViewById<EditText>(R.id.input3)
        val pin4 = findViewById<EditText>(R.id.input4)

        pin1.addTextChangedListener {
            if (!it.isNullOrEmpty()) pin2.requestFocus()
        }

        pin2.addTextChangedListener {
            if (!it.isNullOrEmpty()) pin3.requestFocus()
        }

        pin3.addTextChangedListener {
            if (!it.isNullOrEmpty()) pin4.requestFocus()
        }

        pin2.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pin2.text.isEmpty()) {
                pin1.requestFocus()
            }
            false
        }

        pin3.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pin3.text.isEmpty()) {
                pin2.requestFocus()
            }
            false
        }

        pin4.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pin4.text.isEmpty()) {
                pin3.requestFocus()
            }
            false
        }

        pin4.addTextChangedListener{
            if (it?.isNotEmpty()!!) {

                val pin = pin1.text.toString() +
                        pin2.text.toString() +
                        pin3.text.toString() +
                        pin4.text.toString()

                if (pin == "2005") {
                    Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Wrong PIN", Toast.LENGTH_SHORT).show()

                    // clear all
                    pin1.text.clear()
                    pin2.text.clear()
                    pin3.text.clear()
                    pin4.text.clear()

                    pin1.requestFocus()
                }
            }
        }

        val changeAccBtn = findViewById<ImageView>(R.id.SwitchAcc)
        val confirmation = findViewById<FrameLayout>(R.id.ChangeNum_Comfirmation)
        val proceed = findViewById<Button>(R.id.Proceed)
        val cancel = findViewById<Button>(R.id.Cancel)

        changeAccBtn.setOnClickListener {
            confirmation.visibility = View.VISIBLE
            pin.visibility = View.GONE
            mainLayout.visibility = View.VISIBLE
        }

        confirmation.setOnClickListener {
            confirmation.visibility = View.GONE
        }
        cancel.setOnClickListener {
            confirmation.visibility = View.GONE
        }
        proceed.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@Pin_Code, Number::class.java)
                startActivity(intent)
            }
        })

        val privaceBtn = findViewById<Button>(R.id.Privacy_Btn)
        val  changeMpinBtn = findViewById<Button>(R.id.Change_Mpin)

        privaceBtn.setOnClickListener {
            Toast.makeText(this, "Error Please Try again later", Toast.LENGTH_SHORT).show()
        }

        changeMpinBtn.setOnClickListener {
            Toast.makeText(this, "Error Please Try again later", Toast.LENGTH_SHORT).show()
        }

    }


}
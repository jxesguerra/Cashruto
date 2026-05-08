package com.example.mycashapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.widget.addTextChangedListener

class Number : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.change_num)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ChangeNumber)) { v, insets ->
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

        val changenum_Layout = findViewById<CardView>(R.id.changNum_Layout)
        val next = findViewById<Button>(R.id.next)

        val  otp = findViewById<LinearLayout>(R.id.OTP)

        val num = findViewById<EditText>(R.id.num)

        next.setOnClickListener {

                val cellnumber = num.text.toString()

                if (cellnumber == "9953456512") {
                        changenum_Layout.visibility = View.GONE
                        otp.visibility = View.VISIBLE
                        Toast.makeText(this, "Youre OTP is :234315", Toast.LENGTH_SHORT).show()
                    }
                else {
                    Toast.makeText(this, "That phone Number has been not yet registered", Toast.LENGTH_SHORT).show()
                }
        }

        //otpnum
        val otp1 = findViewById<EditText>(R.id.OTP1)
        val otp2 = findViewById<EditText>(R.id.OTP2)
        val otp3 = findViewById<EditText>(R.id.OTP3)
        val otp4 = findViewById<EditText>(R.id.OTP4)
        val otp5 = findViewById<EditText>(R.id.OTP5)
        val otp6 = findViewById<EditText>(R.id.OTP6)

        otp1.addTextChangedListener {
            if (!it.isNullOrEmpty()) otp2.requestFocus()
        }

        otp2.addTextChangedListener {
            if (!it.isNullOrEmpty()) otp3.requestFocus()
        }

        otp3.addTextChangedListener {
            if (!it.isNullOrEmpty()) otp4.requestFocus()
        }

        otp3.addTextChangedListener {
            if (!it.isNullOrEmpty()) otp4.requestFocus()
        }

        otp4.addTextChangedListener {
            if (!it.isNullOrEmpty()) otp5.requestFocus()
        }

        otp5.addTextChangedListener {
            if (!it.isNullOrEmpty()) otp6.requestFocus()
        }


        otp2.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && otp2.text.isEmpty()) {
                otp1.requestFocus()
            }
            false
        }

        otp3.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && otp3.text.isEmpty()) {
                otp2.requestFocus()
            }
            false
        }

        otp4.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && otp4.text.isEmpty()) {
                otp3.requestFocus()
            }
            false
        }

        otp5.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && otp5.text.isEmpty()) {
                otp4.requestFocus()
            }
            false
        }
        otp6.setOnKeyListener { _, keyCode, _ ->
            if (keyCode == KeyEvent.KEYCODE_DEL && otp6.text.isEmpty()) {
                otp5.requestFocus()
            }
            false
        }


        otp6.addTextChangedListener{
            if (it?.isNotEmpty()!!) {

                val otp = otp1.text.toString() +
                        otp2.text.toString() +
                        otp3.text.toString() +
                        otp4.text.toString() +
                        otp5.text.toString() +
                        otp6.text.toString()

                if (otp == "234315") {
                    Toast.makeText(this, "Succesfull Change Number", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Pin_Code::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Wrong otp", Toast.LENGTH_SHORT).show()

                    // clear all
                    otp1.text.clear()
                    otp2.text.clear()
                    otp3.text.clear()
                    otp4.text.clear()
                    otp5.text.clear()
                    otp6.text.clear()

                    otp1.requestFocus()
                }
            }
        }

        val  resend_Otp = findViewById<TextView>(R.id.Resend)

        resend_Otp.setOnClickListener {
            Toast.makeText(this, "Youre OTP is :234315", Toast.LENGTH_SHORT).show()
        }

    }



}
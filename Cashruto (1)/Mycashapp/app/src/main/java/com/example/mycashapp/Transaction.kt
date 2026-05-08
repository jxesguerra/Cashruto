package com.example.mycashapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams

class Transaction : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.transaction_history)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Transaction_Layout)) { v, insets ->
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

        General_buttonHelper.setup(this)

        window.navigationBarColor = ContextCompat.getColor(this, R.color.brown)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.isAppearanceLightNavigationBars = false

    }


}
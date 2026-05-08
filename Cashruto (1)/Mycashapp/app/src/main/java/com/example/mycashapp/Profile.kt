package com.example.mycashapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Profile_Layout)) { v, insets ->
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

        val logoutBtn = findViewById<Button>(R.id.Logout)

        logoutBtn.setOnClickListener {
            val intent = Intent(this, Pin_Code::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            Toast.makeText(this, "Successfully Log out", Toast.LENGTH_SHORT).show()
            this.startActivity(intent)
        }

    }


}
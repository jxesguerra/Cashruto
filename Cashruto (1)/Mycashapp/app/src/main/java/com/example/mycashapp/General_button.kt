package com.example.mycashapp
import android.content.Intent
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

object General_buttonHelper {

    fun setup(activity: AppCompatActivity) {

        val homeBtn = activity.findViewById<LinearLayout>(R.id.homeBtn)
        val mailBtn = activity.findViewById<LinearLayout>(R.id.MailBtn)
        val profileBtn = activity.findViewById<LinearLayout>(R.id.ProfileBtn)
        val transactionBtn = activity.findViewById<LinearLayout>(R.id.transaction_HistoryBtn)



        homeBtn.setOnClickListener {
            val intent = Intent(activity, Home::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(intent)

        }

        mailBtn.setOnClickListener {
            val  intent = Intent(activity, Mail::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(intent)

        }

        transactionBtn.setOnClickListener {
            val  intent = Intent(activity, Transaction::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(intent)

        }

        profileBtn.setOnClickListener {
            val  intent = Intent(activity, Profile::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(intent)

        }

    }

}
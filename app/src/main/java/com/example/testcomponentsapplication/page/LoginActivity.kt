package com.example.testcomponentsapplication.page

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.testcomponentsapplication.R

class LoginActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailString = intent.getStringExtra("email")

        val textView = this.findViewById<TextView>(R.id.text_view)
        textView.text = emailString

    }
}
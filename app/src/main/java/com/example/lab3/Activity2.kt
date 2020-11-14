package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_1.*

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val button = findViewById<Button>(R.id.button)
        val button1 = findViewById<Button>(R.id.button2)

        button.setOnClickListener() {
            finish()
        }

        button1.setOnClickListener() {
            startActivityForResult(Intent(applicationContext, Activity3::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 0)
            finish()
    }


}
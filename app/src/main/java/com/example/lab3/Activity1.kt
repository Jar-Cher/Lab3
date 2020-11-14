package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_1.*

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val button = findViewById<Button>(R.id.button)
        val button3 = findViewById<Button>(R.id.button3)

        button.setOnClickListener() {
            startActivity(Intent(applicationContext, Activity2::class.java))
        }

        button3.setOnClickListener() {
            startActivity(Intent(applicationContext, ActivityAbout::class.java))
        }

        Nav.setNavigationItemSelectedListener {
            Log.d("Minor", "suces")
            if (it.itemId == R.id.button3)
        {
            Log.d("Major", "success")
            startActivity(Intent(this, ActivityAbout::class.java))
            Drawer.closeDrawer(GravityCompat.START, true)
        }

            true }
    }

}
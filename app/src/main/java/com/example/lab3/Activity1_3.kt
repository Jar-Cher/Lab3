package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_1.*

class Activity1_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        button.setOnClickListener() {
            startActivity(Intent(applicationContext, Activity2_3::class.java))
        }

        button3.setOnClickListener() {
            startActivity(Intent(applicationContext, ActivityAbout::class.java))
            Drawer.closeDrawer(GravityCompat.START, true)
        }
    }

}
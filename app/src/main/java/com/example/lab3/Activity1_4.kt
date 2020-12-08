package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_1.Drawer
import kotlinx.android.synthetic.main.activity_1.button
import kotlinx.android.synthetic.main.activity_1.button3
import kotlinx.android.synthetic.main.activity_1_4.*

class Activity1_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1_4)

        button.setOnClickListener() {
            startActivity(Intent(applicationContext, Activity2_4::class.java))
        }

        button1.setOnClickListener() {
            startActivity(Intent(applicationContext, Activity3_4::class.java))
        }

        button3.setOnClickListener() {
            startActivity(Intent(applicationContext, ActivityAbout_4::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT))
            Drawer.closeDrawer(GravityCompat.START, true)
        }
    }

}
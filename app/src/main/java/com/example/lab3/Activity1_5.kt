package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_1.Drawer
import kotlinx.android.synthetic.main.activity_1.button
import kotlinx.android.synthetic.main.activity_1.button3
import kotlinx.android.synthetic.main.activity_1_4.*

class Activity1_5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1_5)
    }
}

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        button.setOnClickListener() {
            Navigation.findNavController(requireView()).navigate()
        }

        button1.setOnClickListener() {
            Navigation.findNavController(requireView()).navigate()
        }

        button3.setOnClickListener() {
            startActivity(Intent(context, ActivityAbout_5::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT))
            Drawer.closeDrawer(GravityCompat.START, true)
        }

        return view
    }

}
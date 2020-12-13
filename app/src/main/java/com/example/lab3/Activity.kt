package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_1.Drawer
import kotlinx.android.synthetic.main.activity_1.button3
import kotlinx.android.synthetic.main.fragment_1_5.view.*


class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_5)

        button3.setOnClickListener() {

            val currentFragment = Navigation.findNavController(this, R.id.nav_host_fragment).currentDestination!!.id

            when {
                currentFragment == R.id.fragment1_5 ->
                    startActivity(Intent(this, ActivityAbout::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT))
                currentFragment == R.id.fragment2_5 ->
                    startActivity(Intent(this, ActivityAbout::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK))
                else ->
                    startActivity(Intent(this, ActivityAbout::class.java))
            }
            Drawer.closeDrawer(GravityCompat.START, true)
        }
    }

}

class Fragment1_5 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_1_5, container, false)

        view.button.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_fragment1_5_to_fragment2_5)
        }

        view.button1.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_fragment1_5_to_fragment3_5)
        }

        return view
    }

}
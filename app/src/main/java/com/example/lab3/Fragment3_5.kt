package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_1.Drawer
import kotlinx.android.synthetic.main.activity_1.button
import kotlinx.android.synthetic.main.activity_1.button3
import kotlinx.android.synthetic.main.activity_3.*
import kotlinx.android.synthetic.main.fragment_3_5.view.*

class Fragment3_5 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_3_5, container, false)

        view.button.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_fragment3_5_to_fragment1_5)
        }

        view.button2.setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_fragment3_5_to_fragment2_5)
        }

        return view
    }

}
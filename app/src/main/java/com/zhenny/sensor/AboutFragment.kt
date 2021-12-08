package com.zhenny.sensor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {

    lateinit var aboutRecyclerView: RecyclerView
    lateinit var aboutSensorButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val aboutNames: List<String> = listOf("Version 1.0", "Author: Zhenny_Slavecky")

        aboutSensorButton=view.findViewById(R.id.about_sensor_button)
        aboutRecyclerView = view.findViewById(R.id.about_recycler_view)
        aboutRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        aboutRecyclerView.adapter = AboutAdapter(aboutNames)

        aboutSensorButton.setOnClickListener {
         val link = Uri.parse("https://developer.android.google.cn/reference/android/hardware/SensorManager")
         val intent = Intent(Intent.ACTION_VIEW, link)
         context?.startActivity(intent)
        }

        return view
    }


}
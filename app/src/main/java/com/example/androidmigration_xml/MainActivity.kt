package com.example.androidmigration_xml // ktlint-disable package-name

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var titleBottom: TextView
    lateinit var imageCenter: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    /**
     * function that init the UI Components
     */
    private fun initComponents() {
        //titleBottom = findViewById(R.id.bottom_title)
        //imageCenter = findViewById(R.id.center_image)
    }
}

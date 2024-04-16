package com.example.androidmigration_xml // ktlint-disable package-name

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
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
        titleBottom = findViewById(R.id.bottom_title)
        imageCenter = findViewById(R.id.center_image)

        imageCenter.visibility = View.GONE

        Handler().postDelayed({
            imageCenter.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            imageCenter.startAnimation(animation)
        }, 100)

        Handler().postDelayed({
            val animationOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            imageCenter.startAnimation(animationOut)
            titleBottom.startAnimation(animationOut)
        }, 3000)

        Handler().postDelayed({
            imageCenter.visibility = View.GONE
            titleBottom.visibility = View.GONE
        }, 4000)
    }
}

package com.example.androidmigration_xml.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmigration_xml.R


class SplashActivity : AppCompatActivity() {
    lateinit var titleBottom: TextView
    lateinit var imageCenter: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initComponents()
    }

    /**
     * function that init the UI Components
     */
    private fun initComponents() {
        titleBottom = findViewById(R.id.bottom_title)
        imageCenter = findViewById(R.id.center_image)

        imageCenter.visibility = View.GONE

        animateFadeIn()
        animateFadeOut()
        hideElements()
    }

    /**
     * function that fade in the center image
     */
    private fun animateFadeIn() {
        Handler().postDelayed({
            imageCenter.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            imageCenter.startAnimation(animation)
        }, 100)
    }

    /**
     * function that fade in the center image & title
     */
    private fun animateFadeOut() {
        Handler().postDelayed({
            val animationOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            imageCenter.startAnimation(animationOut)
            titleBottom.startAnimation(animationOut)
        }, 3000)
    }

    /**
     * function that hide the center image & title
     */
    private fun hideElements() {
        Handler().postDelayed({
            imageCenter.visibility = View.GONE
            titleBottom.visibility = View.GONE

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 4000)
    }
}

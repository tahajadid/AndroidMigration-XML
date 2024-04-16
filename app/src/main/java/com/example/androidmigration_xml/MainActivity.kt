package com.example.androidmigration_xml // ktlint-disable package-name

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmigration_xml.StaticsElements.VERSION_LIST

class MainActivity : AppCompatActivity() {

    var versionAdapter: VersionAdapter? = null
    lateinit var versionList: RecyclerView
    lateinit var navigateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    /**
     * function that init the UI Components
     */
    private fun initComponents() {
        versionList = findViewById(R.id.versionList)
        navigateButton = findViewById(R.id.navigate_button)

        versionAdapter = VersionAdapter(
            this,
            VERSION_LIST,
        )

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        versionList.layoutManager = layoutManager
        versionList.adapter = versionAdapter

        navigateButton.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/about/versions"))
            startActivity(i)
        }
    }
}

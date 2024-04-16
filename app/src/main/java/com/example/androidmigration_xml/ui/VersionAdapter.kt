package com.example.androidmigration_xml.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmigration_xml.R
import com.example.androidmigration_xml.data.VersionInfo

class VersionAdapter(
    private val context: Context?,
    private var listOfVersion: ArrayList<VersionInfo>,
) : RecyclerView.Adapter<VersionAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var versionNumber: TextView
        lateinit var versionDescription: TextView
        lateinit var versionIcon: ImageView

        /**
         * Show the data in the views
         */
        @SuppressLint("ResourceAsColor")
        fun bindView(item: VersionInfo, position: Int) {
            versionNumber = itemView.findViewById(R.id.version_number)
            versionDescription = itemView.findViewById(R.id.version_description)
            versionIcon = itemView.findViewById(R.id.version_logo)

            // set the section title
            versionNumber.text = item.version.toString()
            versionDescription.text = item.description.toString()

            versionIcon.setImageResource(getImage(item.icon.toString()))
        }

        private fun getImage(icon: String): Int {
            when(icon) {
                "android_5" -> return R.drawable.android_5
                "android_6" -> return R.drawable.android_6
                "android_7" -> return R.drawable.android_7
                "android_8" -> return R.drawable.android_8
                "android_9" -> return R.drawable.android_9
                "android_10" -> return R.drawable.android_10
                "android_11" -> return R.drawable.android_11
                "android_12" -> return R.drawable.android_12
                "android_13" -> return R.drawable.android_13
                else-> return R.drawable.android_14
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.version_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfVersion[position]
        holder.bindView(item, position)
    }

    override fun getItemCount(): Int {
        return listOfVersion.size
    }
}

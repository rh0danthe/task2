package com.example.task2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val textView1: TextView = findViewById(R.id.detail_text1)
        val textView2: TextView = findViewById(R.id.detail_text2)
        val imageView: ImageView = findViewById(R.id.detail_image)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("image", 0)

        textView1.text = title
        textView2.text = description
        imageView.setImageResource(imageResId)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}

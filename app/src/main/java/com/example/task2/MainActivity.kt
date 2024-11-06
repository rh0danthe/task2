package com.example.task2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val itemContainer: LinearLayout = findViewById(R.id.item_container)

        for (i in 1..5) {
            val view = layoutInflater.inflate(R.layout.item_layout, itemContainer, false)
            view.findViewById<TextView>(R.id.textView1).text = "Заголовок $i"
            view.findViewById<TextView>(R.id.textView2).text = "Описание $i"
            view.findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.img)

            view.setOnClickListener {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("title", "Заголовок $i")
                intent.putExtra("description", "Описание $i")
                intent.putExtra("image", R.drawable.img)
                startActivity(intent)
            }
            itemContainer.addView(view)
        }
    }
}


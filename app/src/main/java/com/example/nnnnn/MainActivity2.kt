package com.example.nnnnn

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val imageGet=findViewById<ImageView>(R.id.imageGet)
        val nameGet=findViewById<TextView>(R.id.nameGet)
        val ageGet=findViewById<TextView>(R.id.ageGet)

        val img=intent.extras?.getString("img")
        val name=intent.extras?.getString("name")
        val age=intent.extras?.getString("age")

        nameGet.text=name
        ageGet.text=age
        if (img != null){
            imageGet.setImageResource(img.toInt())
        }


    }
}
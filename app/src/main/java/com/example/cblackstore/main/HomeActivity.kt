package com.example.cblackstore.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cblackstore.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Gắn fragment HomeFragment vào activity
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
}

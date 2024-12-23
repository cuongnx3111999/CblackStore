package com.example.cblackstore.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cblackstore.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.cblackstore.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Kiểm tra trạng thái đăng nhập
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser == null) {
            // Chuyển sang LoginActivity nếu chưa đăng nhập
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Kết thúc MainActivity để không quay lại
        } else {
            // Hiển thị nội dung chính nếu đã đăng nhập
            setContentView(R.layout.activity_home)
        }
    }
}

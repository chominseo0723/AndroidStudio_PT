package com.example.fisrtandroidapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.mainview)

        // 상태바/내비바 겹침 방지
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // Lake Louise 텍스트 클릭 → PasswordCheckActivity로 이동
        val titleText = findViewById<TextView>(R.id.titleText)
        titleText.setOnClickListener {
            startActivity(Intent(this, PasswordCheckActivity::class.java))
        }
    }
}
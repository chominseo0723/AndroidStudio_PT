package com.example.fisrtandroidapp


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class PasswordCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_password_check)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val btnConfirm = findViewById<MaterialButton>(R.id.btnConfirm)
        val til = findViewById<TextInputLayout>(R.id.tilPassword)

        btnConfirm.setOnClickListener {
            val pw = etPassword.text?.toString().orEmpty()
            if (pw.isBlank()) {
                til.error = "비밀번호를 입력해 주세요."
            } else {
                til.error = null
                android.widget.Toast.makeText(this, "확인되었습니다.", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
    }
}
package com.loginregisterpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Mendapatkan referensi ke elemen UI
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvDontHave = findViewById<TextView>(R.id.tvDontHave)

        // Menambahkan listener untuk tombol Login
        btnLogin.setOnClickListener {
            // Mengambil nilai dari field input
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Validasi input user
            if (email.isEmpty() || password.isEmpty()) {
                // Menampilkan pesan error jika ada field yang kosong
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Menampilkan pesan error jika format email tidak valid
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                // Menampilkan pesan error jika password kurang dari 6 karakter
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                // Pindah ke RegisterActivity setelah login berhasil
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

        // Menambahkan listener untuk teks "Don't Have Account? Sign Up"
        tvDontHave.setOnClickListener {
            // Pindah ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
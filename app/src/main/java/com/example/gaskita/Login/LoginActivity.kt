package com.example.gaskita.Login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gaskita.Dashboard.HomeActivity
import com.example.gaskita.R

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextEmailAddress = findViewById<EditText>(R.id.editTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        //tombol aksi ketika tombol login diklik
        btnLogin.setOnClickListener {
            val email: String = editTextEmailAddress.text.toString()
            // Intent untuk berpindah ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(KEY_USERNAME, email)
            startActivity(intent)
            
            // Menutup LoginActivity agar user tidak bisa kembali ke login dengan tombol Back
            finish()

            Toast.makeText(this,
                "Login Berhasil",
                Toast.LENGTH_SHORT)
                .show()
        }
    }
    // Constant key untuk passing data username antar Activity
    companion object{
        const val KEY_USERNAME = "username"
    }
}

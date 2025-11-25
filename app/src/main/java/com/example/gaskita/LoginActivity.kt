package com.example.gaskita

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

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
        editTextEmailAddress.text.toString()
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        editTextPassword.text.toString()
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email: String = editTextEmailAddress.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KEY_USERNAME, email)
            startActivity(intent)

            Toast.makeText(this,
                "Button Login clicked",
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    companion object{
        const val KEY_USERNAME = "username"
    }
}



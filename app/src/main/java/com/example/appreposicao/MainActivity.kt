package com.example.appreposicao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            authenticate(email, password)
        }

    }

    fun authenticate(user: String, password: String){

        if (user.isEmpty() && password.isEmpty())
            Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
        else if(user.isEmpty())
            Toast.makeText(this, "Usuário não pode ser vazio!", Toast.LENGTH_SHORT).show()
        else if(password.isNullOrEmpty())
            Toast.makeText(this, "Senha não pode ser vazia!", Toast.LENGTH_SHORT).show()
        else if(user != "admin" || password != "admin")
            Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show()
        else{
            val intent = Intent (this, SuccessActitvity::class.java)
            startActivity(intent)
        }

    }
}
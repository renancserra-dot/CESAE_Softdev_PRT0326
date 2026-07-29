package com.example.cesaeeats

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cesaeeats.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonLogin.setOnClickListener {

            var usernameIntroduzido = binding.editUsername.text.toString()
            var passwordIntroduzida = binding.editPassword.text.toString()

            if (usernameIntroduzido.isEmpty() || passwordIntroduzida.isEmpty()) {
                Toast.makeText(applicationContext, "Preencha todos os campos", Toast.LENGTH_SHORT)
                    .show()
            } else if (usernameIntroduzido.equals("joaquim") && passwordIntroduzida.equals("123")) {
                // LOGIN CORRETO

                var i = Intent(this, MainActivity::class.java)
                startActivity(i)

            } else {
                binding.editUsername.setText("")
                binding.editPassword.setText("")
                Toast.makeText(applicationContext, "Login inválido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
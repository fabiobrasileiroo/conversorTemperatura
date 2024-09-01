package com.example.conversortemperatura

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.buttonConverter.setOnClickListener {
            if(!binding.editCelsius.text.toString().isEmpty()) {
                binding.textErrorValue.text = ""
                val celsius = binding.editCelsius.text.toString().toDouble()
                val fahrenheit = String.format("%.2f", celsius *1.88 +32)
                binding.textResultado.text = "${fahrenheit} *F"
            } else {
                 binding.textErrorValue.text = "Digito um valor"
                 binding.textResultado.text = ""
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
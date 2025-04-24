package com.example.mercearia

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textviewCoca = findViewById<TextView>(R.id.textView10)
        val textviewGuaran = findViewById<TextView>(R.id.textView11)
        textviewCoca.setOnClickListener{
            intent.putExtra("cod", "123")
            setResult(0,intent)
            finish()
        }
        textviewGuaran.setOnClickListener{
            intent.putExtra("cod", "456")
            setResult(0,intent)
            finish()
        }


    }
}
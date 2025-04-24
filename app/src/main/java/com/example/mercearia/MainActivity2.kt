package com.example.mercearia

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var codEditText: EditText
    private lateinit var qtdEditText: EditText
    private lateinit var valorEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botaoConfirmar = findViewById<Button>(R.id.button3)
        val botaoListar = findViewById<Button>(R.id.button4)
        codEditText = findViewById<EditText>(R.id.editTextNumber)
        qtdEditText = findViewById<EditText>(R.id.editTextNumber2)
        valorEditText = findViewById<EditText>(R.id.editTextNumberDecimal)
        botaoConfirmar.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("cod", codEditText.text.toString())
            intent.putExtra("qtd", qtdEditText.text.toString())
            intent.putExtra("valor", valorEditText.text.toString())
            startActivity(intent)
        }
        botaoListar.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivityForResult(intent,0)
        }
    }
    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == 0) {
                val cod = data?.getStringExtra("cod")
                codEditText.setText(cod)
            }
        }
    }
}
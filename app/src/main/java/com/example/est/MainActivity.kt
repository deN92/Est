package com.example.est

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_words_add : Button = findViewById(R.id.btn_words_add)
        val btn_confirm : Button = findViewById(R.id.btn_confirm)
        val tv_word : TextView = findViewById(R.id.tv_word)
//
        btn_confirm.setOnClickListener{
            val content = File(filesDir, "E-st.txt").readText()
            tv_word.setText(content)
        }


//        btn_confirm.setText()

        btn_words_add.setOnClickListener{
            val intent = Intent(this@MainActivity, AddwordsActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.est

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
//import com.google.android.material.textfield.TextInputLayout
import java.io.File

class AddwordsActivity : AppCompatActivity() {

    data class Wenua_pair(
        val wen: String,
        val wua: String
    )

    val wenua = mutableListOf<Wenua_pair>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addwords)

        val tiet_worden : TextInputEditText = findViewById(R.id.tiet_worden)
        val tiet_wordua : TextInputEditText = findViewById(R.id.tiet_wordua)
//        var til_worden :TextInputLayout = findViewById(R.id.til_worden)
//        var til_wordua :TextInputLayout = findViewById(R.id.til_wordua)
        val btn_addword : Button = findViewById(R.id.btn_add_word)


        btn_addword.setOnClickListener{
            wenua.add(Wenua_pair(tiet_worden.text.toString() ,tiet_wordua.text.toString()))
            File(filesDir, "E-st.txt").writeText(wenua.toString())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
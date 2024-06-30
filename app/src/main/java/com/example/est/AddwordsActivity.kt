package com.example.est

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import org.json.JSONArray
import org.json.JSONObject
//import com.google.android.material.textfield.TextInputLayout
import java.io.File

class AddwordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addwords)

        val tiet_p1 : TextInputEditText = findViewById(R.id.tiet_property1)
        val tiet_p2 : TextInputEditText = findViewById(R.id.tiet_property2)
        val tiet_p3 : TextInputEditText = findViewById(R.id.tiet_property3)
        val tiet_p4 : TextInputEditText = findViewById(R.id.tiet_property4)
        val tiet_p5 : TextInputEditText = findViewById(R.id.tiet_property5)
        val btn_addword : Button = findViewById(R.id.btn_add_word)


        btn_addword.setOnClickListener{
            val content = File(filesDir, "E-st.txt").readText()
            var jsa = JSONArray(content)
            var jso1 = JSONObject()
            jso1.put("Виробник", tiet_p1.text.toString())
            jso1.put("Модель",tiet_p2.text.toString())
            jso1.put("Колір",tiet_p3.text.toString())
            jso1.put("Ціна",tiet_p4.text.toString())
            jso1.put("Опис",tiet_p5.text.toString())

            jsa.put(jso1)
            File(filesDir, "E-st.txt").writeText(jsa.toString())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
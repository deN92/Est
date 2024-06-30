package com.example.est

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Text
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

        val rb1 : RadioButton = findViewById(R.id.rb_value1)
        val rb2 : RadioButton = findViewById(R.id.rb_value2)
        val rb3 : RadioButton = findViewById(R.id.rb_value3)
        val rb4 : RadioButton = findViewById(R.id.rb_value4)
        val btn_words_add : Button = findViewById(R.id.btn_words_add)
        val btn_confirm : Button = findViewById(R.id.btn_confirm)
        val tv_word : TextView = findViewById(R.id.tv_word)
        val btn_calc : Button = findViewById(R.id.btn_calc)
        val tbl1 : TableLayout = findViewById(R.id.tbl1)

        btn_confirm.setOnClickListener{
            val content = File(filesDir, "E-st.txt").readText()

            var jsa = JSONArray(content)

            var nn1 = jsa.getJSONObject(0).getString("Виробник")
            var nn2 = jsa.getJSONObject(0).getString("Модель")
            var nn3 = jsa.getJSONObject(0).getString("Колір")
            var nn4 = jsa.getJSONObject(0).getString("Ціна")

            for (i in 0 until jsa.length()) {
                val tableRow = TableRow(this)
                tableRow.layoutParams = LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
                )

                var tv1 = TextView(this)
                var tv2 = TextView(this)
                var tv3 = TextView(this)
                var tv4 = TextView(this)
                var tv5 = TextView(this)

                tv1.setText((i+1).toString())
                tv2.setText(jsa.getJSONObject(i).getString("Виробник").toString()+ " ")
                tv3.setText(jsa.getJSONObject(i).getString("Модель").toString()+ " ")
                tv4.setText(jsa.getJSONObject(i).getString("Колір").toString()+ " ")
                tv5.setText(jsa.getJSONObject(i).getString("Ціна").toString()+ " ")
                tableRow.addView(tv1)
                tableRow.addView(tv2)
                tableRow.addView(tv3)
                tableRow.addView(tv4)
                tableRow.addView(tv5)

                tbl1.addView(tableRow, i)
            }
            tv_word.setText(nn1.toString())
        }

        btn_words_add.setOnClickListener{
            val intent = Intent(this@MainActivity, AddwordsActivity::class.java)
            startActivity(intent)
        }

        btn_calc.setOnClickListener{
            val intent2 = Intent(this@MainActivity, CalcActivity2::class.java)
            startActivity(intent2)
        }
    }
}
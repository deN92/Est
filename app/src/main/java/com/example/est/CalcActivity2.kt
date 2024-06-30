package com.example.est

import kotlin.math.*
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.est.databinding.ActivityCalc2Binding
import java.lang.reflect.Array
import kotlin.math.*

class CalcActivity2 : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCalc2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalc2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.toolbar)

//        val navController = findNavController(R.id.nav_host_fragment_content_calc2)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        val btn_n1 : Button = findViewById(R.id.btn_n1)
        val btn_n2 : Button = findViewById(R.id.btn_n2)
        val btn_n3 : Button = findViewById(R.id.btn_n3)
        val btn_n4 : Button = findViewById(R.id.btn_n4)
        val btn_n5 : Button = findViewById(R.id.btn_n5)
        val btn_n6 : Button = findViewById(R.id.btn_n6)
        val btn_n7 : Button = findViewById(R.id.btn_n7)
        val btn_n8 : Button = findViewById(R.id.btn_n8)
        val btn_n9 : Button = findViewById(R.id.btn_n9)
        val btn_n0 : Button = findViewById(R.id.btn_n0)

        val btn_plus : Button = findViewById(R.id.btn_plus)
        val btn_minus : Button = findViewById(R.id.btn_minus)
        val btn_mult : Button = findViewById(R.id.btn_multiply)
        val btn_div : Button = findViewById(R.id.btn_div)
        val btn_equal : Button = findViewById(R.id.btn_equal)
        val btn_power_off :Button = findViewById(R.id.btn_power_of)
        val btn_sqrt : Button = findViewById(R.id.btn_sqrt)
        val btn_bracket: Button = findViewById(R.id.btn_bracket)

        val tV1 : TextView = findViewById(R.id.tV1)
        val tV2 : TextView = findViewById(R.id.tV2)
        val tV3 : TextView = findViewById(R.id.tV3)
        var current_var  = 0.0
        var f  = ""
        tV3.text = ""


        fun settxt(n : String){
            tV1.setText(tV1.text.toString()+n)
            tV3.setText(tV3.text.toString()+n)
        }

        btn_n0.setOnClickListener{
            settxt("0")
        }

        btn_n1.setOnClickListener{
            settxt("1")
        }

        btn_n2.setOnClickListener{
            settxt("2")
        }

        btn_n3.setOnClickListener{
            settxt("3")
        }

        btn_n4.setOnClickListener{
            settxt("4")
        }

        btn_n5.setOnClickListener{
            settxt("5")
        }

        btn_n6.setOnClickListener{
            settxt("6")
        }

        btn_n7.setOnClickListener{
            settxt("7")
        }

        btn_n8.setOnClickListener{
            settxt("8")
        }

        btn_n9.setOnClickListener{
            settxt("9")
        }

        fun m1(){
            if (tV1.text.toString() != "") {
                if (f == "+") {
                    current_var += tV1.text.toString().toDouble()
                    tV2.text = current_var.toString()
                }
                if (f == "-") {
                    if(tV2.text !="") {
                        current_var -= tV1.text.toString().toDouble()
                    }else {current_var = tV1.text.toString().toDouble()}
                    tV2.text = current_var.toString()
                }
                if (f == "*") {
                    current_var *= tV1.text.toString().toDouble()
                    tV2.text = current_var.toString()
                }
                if (f == ":") {
                    if(tV2.text !="") {
                        current_var /= tV1.text.toString().toDouble()
                    }else { current_var = tV1.text.toString().toDouble()}
                    tV2.text = current_var.toString()
                }
                if (f == "^") {
                    current_var = current_var.pow(tV1.text.toString().toDouble())
                    tV2.text = current_var.toString()
                }
                if (f == "√") {
                    current_var = sqrt(tV1.text.toString().toDouble())
                    tV2.text = current_var.toString()
                }
                tV1.text = ""
            }
        }

        btn_bracket.setOnClickListener{
            tV3.setText("("+tV3.text.toString()+")")
        }

        btn_plus.setOnClickListener{
            tV3.setText(tV3.text.toString()+"+")
            if(tV2.text.toString() == "") {
                f = "+"
            }
            m1()
            f = "+"
        }

        btn_minus.setOnClickListener{
            tV3.setText(tV3.text.toString()+"-")
            if(tV2.text.toString() == "") {
                f = "-"
            }
            m1()
            f = "-"
        }

        btn_mult.setOnClickListener{
            tV3.setText(tV3.text.toString()+"*")
            if(tV2.text.toString() == "") {
                f = "*"
            }
            m1()
            f = "*"
        }

        btn_div.setOnClickListener{
            tV3.setText(tV3.text.toString()+":")
            if(tV2.text.toString() == "") {
                f = ":"
            }
            m1()
            f = ":"
        }

        btn_power_off.setOnClickListener{
            if(tV2.text.toString() == "") {
                f = "^"
            }
            m1()
            f = "^"
        }

        btn_sqrt.setOnClickListener{
            if (tV1.text != "") {
                current_var = sqrt(tV1.text.toString().toDouble())
                tV2.text = current_var.toString()
                tV1.text = ""
            }
            else
                if (tV2.text !="") {
                    current_var = sqrt(tV2.text.toString().toDouble())
                    tV2.text = current_var.toString()
                }
        }

        btn_equal.setOnClickListener{
            var a : String = tV3.text.toString()

            val chars = a.toList()

            val cats = arrayListOf<String>()
//            tV1.text = chars.size.toString()

            var z : String = ""
            for(i in 0..chars.size-1){

                if(chars[i].directionality.name != "EUROPEAN_NUMBER"){
                    cats.add(z)
                    cats.add("n")
                    z=""
                }
                z += chars[i].toString()
////
////                tV1.text = i.toString()
            }
            tV1.text = cats.toString()
//            while (stringVal.length == genList.size) {
//                count++
//            }
//            myfinal = tiet.text.toString().toInt()
//            myNumOrNull +=5
//            myNumOrNull = "5".toInt()
//            tiet.setText(myfinal.toString())
        }
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .setAnchorView(R.id.fab).show()
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_calc2)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
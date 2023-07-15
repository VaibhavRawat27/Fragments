package com.vaibhavrawat.fragments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var activityFragment: ActivityInterface
    var tvActivity: TextView? = null
    var btnClick: Button? = null
    var btnIncrement: Button? = null
    var btnDecrement: Button? = null
    var etText: EditText? = null
    var text = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvActivity = findViewById(R.id.tvActivity)
        btnClick = findViewById(R.id.btnClick)
        btnDecrement = findViewById(R.id.btnDecrement)
        btnIncrement = findViewById(R.id.btnIncrement)
        etText = findViewById(R.id.etText)
        btnClick?.setOnClickListener {
            text = etText?.text.toString()
            activityFragment.changeFragmentName(text)
//            activityFragment.changeFragmentSize()
//            activityFragment.changeFragmentColor()
        }
        btnIncrement?.setOnClickListener {
            activityFragment.changeFragmentIncrement()
        }
        btnDecrement?.setOnClickListener {
            activityFragment.changeFragmentDecrement()
        }
    }

    @SuppressLint("SetTextI18n")
    fun changeFragmentText() {
        tvActivity?.text = "Changed from fragment"
    }
}

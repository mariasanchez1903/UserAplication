package com.example.useraplication

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.useraplication.UserVipAplication.Companion.prefs

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initUI()
    }

    private fun initUI() {
        val btnBack = findViewById<Button>(R.id.btnBack)
        val tvName = findViewById<TextView>(R.id.tvName)
        val userName = prefs.getName()
        btnBack.setOnClickListener{
            prefs.wipe()
            finish()
        }
        tvName.text = "Bienvenido $userName"
        if (prefs.getVIP()){
            setVIPColorBackground()
        }
    }

    fun setVIPColorBackground(){
        val container = findViewById<LinearLayout>(R.id.container)
        container.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
    }

}
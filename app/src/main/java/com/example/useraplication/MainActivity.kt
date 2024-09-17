package com.example.useraplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.useraplication.UserVipAplication.Companion.prefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniUI()
        checkUserValues()
    }
    private fun checkUserValues() {
        if (prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }

    private fun iniUI() {
        val btnContinue = findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener{ accessToDetail()}
    }

    private fun accessToDetail() {
        val etName = findViewById<EditText>(R.id.etName)
        val cbVip = findViewById<CheckBox>(R.id.cbVip)
        val name = etName.text.toString()
        if (name.isNotEmpty()) {
            prefs.saveName(name)
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()
        } else {
            etName.error = "El nombre no puede estar vacío"
        }
    }

    private fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}
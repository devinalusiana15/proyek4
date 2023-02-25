package com.proyek.metagama_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val DaftarBtn = findViewById<Button>(R.id.buttonDaftar)
        DaftarBtn.setOnClickListener{
            val intent = Intent(this,DaftarActivity::class.java)
            startActivity(intent)
        }

        val MasukBtn = findViewById<Button>(R.id.buttonMasuk)
        MasukBtn.setOnClickListener{
            val intent = Intent(this,MasukActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.proyek.metagama_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val btnNextMasuk = findViewById<Button>(R.id.buttonNextMasuk)
        btnNextMasuk.setOnClickListener{
            val intent = Intent(this,MasukActivity::class.java)
            startActivity(intent)
        }
    }
}
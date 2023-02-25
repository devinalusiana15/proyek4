package com.proyek.metagama_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MasukActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        //BACK BUTTON POKOKNYA DIA BAKAL BALIK KE LANDING PAGE!
        val btnBackMasuk: ImageView = findViewById(R.id.ic_backMasuk_btn)
        btnBackMasuk.setOnClickListener {
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }

        val btnMasukApp = findViewById<Button>(R.id.buttonFormMasuk)
        btnMasukApp.setOnClickListener {
            val intent3 = Intent(this, ScannerActivity::class.java)
            startActivity(intent3)
        }
    }
}
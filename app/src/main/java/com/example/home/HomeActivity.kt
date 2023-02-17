package com.example.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //moving page buddha
        val btnBuddha: CardView = findViewById(R.id.buddha)
        btnBuddha.setOnClickListener{
            val intent = Intent(this, ModulBuddha::class.java)
            startActivity(intent)
        }

        //moving page hindu
        val btnHindu: CardView = findViewById(R.id.hindu)
        btnHindu.setOnClickListener{
            val intent2 = Intent(this, ModulHindu::class.java)
            startActivity(intent2)
        }

        //moving page konghucu
        val btnKonghucu: CardView = findViewById(R.id.konghucu)
        btnKonghucu.setOnClickListener{
            val intent3 = Intent(this, ModulKonghucu::class.java)
            startActivity(intent3)
        }
    }

}
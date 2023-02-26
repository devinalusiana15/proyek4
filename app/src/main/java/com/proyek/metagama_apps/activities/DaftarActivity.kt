package com.proyek.metagama_apps.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.proyek.metagama_apps.R

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        val jurusan = listOf("Tek. Informatika", "Tek. Elektro")
        val autoComplete : AutoCompleteTextView = findViewById(R.id.dropdownJurusan)
        val adapter = ArrayAdapter(this, R.layout.list_jurusan, jurusan)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }

        val prodi = listOf("D3 Teknik Informatika", "D4 Teknik Informatika")
        val autoComplete1 : AutoCompleteTextView = findViewById(R.id.dropdownProdi)
        val adapter1 = ArrayAdapter(this, R.layout.list_jurusan, prodi)

        autoComplete1.setAdapter(adapter1)
        autoComplete1.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }


        val btnBackDaftar: ImageView = findViewById(R.id.ic_backDaftar_btn)
        btnBackDaftar.setOnClickListener{
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }

        val btnDaftarApp = findViewById<Button>(R.id.buttonFormDaftar)
        btnDaftarApp.setOnClickListener{
            val Intent = Intent(this, SuccessActivity::class.java)
            startActivity(Intent)
        }
    }
}
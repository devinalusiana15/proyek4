package com.proyek.metagama_apps.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.proyek.metagama_apps.R

class MasukActivity : AppCompatActivity() {
    private lateinit var varEtUsername: EditText
    private lateinit var varEtPassword: EditText
    private lateinit var varBtnMasuk: Button
    private lateinit var varTvNimHandle: TextView
    private lateinit var varTvPasswordHandle: TextView
    private lateinit var varTvLupaPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        varEtUsername = findViewById(R.id.inputUsername)
        varEtPassword = findViewById(R.id.inputPassword)
        varBtnMasuk = findViewById(R.id.buttonFormMasuk)
        varTvNimHandle = findViewById(R.id.textViewNimHandle)
        varTvPasswordHandle = findViewById(R.id.textViewPassHandle)
        varTvLupaPassword = findViewById(R.id.textViewLupaPassword)

        varBtnMasuk.setOnClickListener {
            val nim = varEtUsername.text.toString()
            val password = varEtPassword.text.toString()

            if (nim == "211511011" && password == "123devina123") {
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ScannerActivity::class.java))
                finishAffinity()
            } else if (nim.isEmpty() || password.isEmpty()) {
                if (nim.isEmpty()) {
                    varTvNimHandle.text = "Nim harus diisi"
                } else {
                    varTvNimHandle.text = null
                }
                if (password.isEmpty()) {
                    varTvPasswordHandle.text = "Kata sandi harus diisi"
                } else {
                    varTvPasswordHandle.text = null
                }
                Toast.makeText(this, "Kolom NIM dan Kata Sandi Wajib Diisi!", Toast.LENGTH_SHORT).show()
            } else {
                varTvNimHandle.text = null
                varTvPasswordHandle.text = null
                Toast.makeText(this, "Akun tidak terdaftar", Toast.LENGTH_SHORT).show()
            }
        }

        varTvLupaPassword.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ForgotPassActivity::class.java))
        })
    }
}
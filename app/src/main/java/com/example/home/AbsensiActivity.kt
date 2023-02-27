package com.example.home

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.home.databinding.ActivityAbsensiBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://192.168.0.157/metagama/crud/"
class AbsensiActivity : AppCompatActivity() {

    private lateinit var qrCodeImageView: ImageView
    private lateinit var generateQrCodeButton: Button
    private var nim: String = "211511090"
    private lateinit var binding: ActivityAbsensiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absensi)

//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(Api::class.java)
//
//        retrofit.data().enqueue(object:Callback<Mahasiswa> {
//
//            override fun onResponse(call: Call<Mahasiswa>, response: Response<Mahasiswa>) {
//                for(mahasiswa in it){
//                    Log.e(AbsensiActivity, mahasiswa.toString())
//                }
//            }
//
//            override fun onFailure(call: Call<Mahasiswa>, t: Throwable) {
//                Log.e(AbsensiActivity, t.toString())
//            }
//        })

        qrCodeImageView = findViewById(R.id.qr_code_image_view)
        generateQrCodeButton = findViewById(R.id.generate_qr_code_button)

        generateQrCodeButton.setOnClickListener {
            val qrCodeData = nim // data untuk QR code, bisa diubah
            val qrCodeSize = 500 // ukuran QR code, dalam pixel

            val bitmap = generateQRCode(qrCodeData, qrCodeSize)
            qrCodeImageView.setImageBitmap(bitmap)
        }
    }

    private fun generateQRCode(qrCodeData: String, qrCodeSize: Int): Bitmap? {
        val qrCodeWriter = QRCodeWriter()
        try {
            val bitMatrix: BitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize)
            val width = bitMatrix.width
            val bitmap = Bitmap.createBitmap(width, width, Bitmap.Config.RGB_565)
            for (x in 0 until width) {
                for (y in 0 until width) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) -0x1000000 else -0x1)
                }
            }
            return bitmap
        } catch (e: WriterException) {
            e.printStackTrace()
        }
        return null
    }
}

package com.example.home
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.ApiRetrofit
import com.example.retrofit.MateriAdapter
import com.example.retrofit.MateriModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModulIslam : AppCompatActivity() {

    private val api by lazy{
        ApiRetrofit().endpoint
    }
    private lateinit var materiAdapter: MateriAdapter
    private lateinit var listMateri: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modul_islam)
        setupList()
    }

    override fun onStart() {
        super.onStart()
        getMateri()
    }

    private fun setupList(){
        listMateri = findViewById(R.id.list_materi)
        materiAdapter = MateriAdapter(arrayListOf(), object : MateriAdapter.OnAdapterListener {
            override fun onClick(materi: MateriModel.Data) {
//                val intent = Intent(this@MainActivity, WebViewActivity::class.java)
//                startActivity(intent.putExtra("judul_materi", materi.judul_materi))
//                Toast.makeText(ModulIslam, materi.judul_materi, Toast.LENGTH_LONG).show()
            }
        })
        listMateri.adapter = materiAdapter
    }

    private fun getMateri(){
        api.data().enqueue(object:Callback<MateriModel>{
            override fun onResponse(call: Call<MateriModel>, response: Response<MateriModel>) {
                if(response.isSuccessful){
                    val listData = response.body()!!.materi
                    materiAdapter.setData(listData)
                }
            }

            override fun onFailure(call: Call<MateriModel>, t: Throwable) {
                Log.e("MainActivity",t.toString())
            }

        })
    }
}
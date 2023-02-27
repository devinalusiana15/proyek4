package com.example.retrofit

import java.io.Serializable

data class MateriModel (val materi: List<Data>){
    data class Data(
        val id: String?,
        val judul_materi: String?
    )
}
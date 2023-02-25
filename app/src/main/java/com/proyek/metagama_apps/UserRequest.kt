package com.proyek.metagama_apps

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("nim")
    @Expose
    var nim: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}
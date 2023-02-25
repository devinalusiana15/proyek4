package com.proyek.metagama_apps

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("data")
    @Expose
    var data: User? = null

    class User {
        @SerializedName("nim")
        @Expose
        var nim: String? = null

        @SerializedName("nama")
        @Expose
        var nama: String? = null
    }
}
package com.gerpax.superpoderesandroid.model

import com.google.gson.annotations.SerializedName


data class Urls (
    @SerializedName("type") var type : String? = null,
    @SerializedName("url") var url : String? = null
)

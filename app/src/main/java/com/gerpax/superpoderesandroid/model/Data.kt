package com.gerpax.superpoderesandroid.model

import com.google.gson.annotations.SerializedName


data class Data (
    @SerializedName("offset") var offset : Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("total") var total : Int? = null,
    @SerializedName("count") var count : Int? = null,
    @SerializedName("results") var results : List<Results> = arrayListOf()
)

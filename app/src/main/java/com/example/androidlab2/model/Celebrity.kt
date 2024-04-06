package com.example.androidlab2.model

import com.google.gson.annotations.SerializedName

data class Celebrity(
        @SerializedName("name")
        val name: String?,
        @SerializedName("net_worth")
        val netWorth: Long?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("nationality")
        val nationality: String?,
        @SerializedName("height")
        val height: Double?,
        @SerializedName("birthday")
        val birthday: String?
)



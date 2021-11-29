package com.example.bookstore

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class VolumesResponse {
    @SerializedName("kind")
    @Expose
    val kind: String? = null

    @SerializedName("items")
    @Expose
    var items: List<Volume>? = null

    @SerializedName("totalItems")
    @Expose
    var totalItems = 0
}
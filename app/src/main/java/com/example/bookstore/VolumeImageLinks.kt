package com.example.bookstore

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class VolumeImageLinks {
    @SerializedName("smallThumbnail")
    @Expose
    val smallThumbnail: String? = null

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String? = null
}
package com.example.bookstore.service

import com.example.bookstore.VolumesResponse
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query


interface BookService {
    @GET("/books/v1/volumes")
    fun searchVolumes(
        @Query("q") query: String?,
        @Query("inauthor") author: String?,
        @Query("key") apiKey: String?
    ): Call<VolumesResponse?>?
}
package com.example.bookstore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookstore.VolumesResponse
import com.example.bookstore.service.BookService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Repository
 */
class BookRepository {

    companion object {
        private const val BOOK_SEARCH_SERVICE_BASE_URL =
            "https://www.googleapis.com/"
    }

    private val bookSearchService: BookService
    private val volumesResponseLiveData: MutableLiveData<VolumesResponse> = MutableLiveData()

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level= HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        bookSearchService = retrofit2.Retrofit.Builder()
            .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookService::class.java)
        //Todo       popular a viewModel com resultado do retrofit
    }

    fun searchVolumes(keyword: String?, author: String?, apiKey: String?) {
        bookSearchService.searchVolumes(keyword, author, apiKey)
            ?.enqueue(object : Callback<VolumesResponse?> {
                override fun onResponse(
                    call: Call<VolumesResponse?>,
                    response: Response<VolumesResponse?>
                ) {
                    if (response.body() != null) {
                        volumesResponseLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<VolumesResponse?>, t: Throwable) {
                    volumesResponseLiveData.postValue(null)
                }
            })
    }

    fun getVolumesResponseLiveData(): LiveData<VolumesResponse> {
        return volumesResponseLiveData
    }
}
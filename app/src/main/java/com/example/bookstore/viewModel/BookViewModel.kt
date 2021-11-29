package com.example.bookstore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.bookstore.VolumesResponse
import com.example.bookstore.repository.BookRepository
import io.github.cdimascio.dotenv.Dotenv
import android.app.Application

import androidx.annotation.NonNull

/**
 * ViewModel
 */
class BookViewModel : ViewModel() {

    private lateinit var bookRepository: BookRepository
    private  var volumesResponseLiveData: LiveData<VolumesResponse> = bookRepository.getVolumesResponseLiveData()

    fun searchVolumes(keyword: String?, author: String?) {

        val dotenv = Dotenv.configure().directory("/assets").filename("file.env").load()
        bookRepository.searchVolumes(keyword, author, dotenv["GOOGLE_API_KEY"])
    }

    fun getVolumesResponseLiveData(): LiveData<VolumesResponse> {
        return volumesResponseLiveData
    }
}
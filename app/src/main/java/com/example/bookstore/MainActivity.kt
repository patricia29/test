package com.example.bookstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookstore.repository.BookRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity(private val repository: BookRepository) : AppCompatActivity() {

    /**
     * OnCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, BookFragment(), "bookFragment")
                .commit()
        }
    }
}
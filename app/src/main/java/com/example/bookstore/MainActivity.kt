package com.example.bookstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity() : AppCompatActivity() {

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
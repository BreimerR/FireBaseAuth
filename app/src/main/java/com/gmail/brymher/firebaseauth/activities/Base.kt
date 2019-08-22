package com.gmail.brymher.firebaseauth.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class Base(val layout: Int) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        init(savedInstanceState)
    }

    abstract fun init(savedInstanceState: Bundle?)

}
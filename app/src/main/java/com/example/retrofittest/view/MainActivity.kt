package com.example.retrofittest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import com.example.retrofittest.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "歡迎回來", Toast.LENGTH_LONG).show()
    }
}

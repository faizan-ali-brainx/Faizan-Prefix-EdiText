package com.example.custom_view_training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<com.example.faizan_prefix_edittext.PrefixEditTextView>(R.id.et_test)
        editText.assignPrefix("$")
    }
}
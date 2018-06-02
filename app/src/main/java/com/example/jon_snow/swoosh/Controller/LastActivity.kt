package com.example.jon_snow.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.jon_snow.swoosh.R

class LastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)
    }
    fun goHome(view:View)
    {
        var homeIntent = Intent(this,MainActivity::class.java)
        startActivity(homeIntent)
    }
}

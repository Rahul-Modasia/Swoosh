package com.example.jon_snow.swoosh.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.jon_snow.swoosh.Model.Player
import com.example.jon_snow.swoosh.R

import com.example.jon_snow.swoosh.Utilities.PLAYER_EXTRA

import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {
    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        player=intent.getParcelableExtra(PLAYER_EXTRA)
        lookingTxt.text="Looking For A ${player.league} ${player.skill} Near You..."
        val begin = Intent(this,MainActivity::class.java)
        val handler = Handler()
        handler.postDelayed({ startActivity(begin) }, 3000)
    }
}

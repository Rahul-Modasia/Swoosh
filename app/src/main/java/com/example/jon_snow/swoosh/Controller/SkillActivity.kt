package com.example.jon_snow.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.jon_snow.swoosh.Model.Player

import com.example.jon_snow.swoosh.R
import com.example.jon_snow.swoosh.Utilities.PLAYER_EXTRA

import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    lateinit var player: Player
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(PLAYER_EXTRA,player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player=intent.getParcelableExtra<Player>(PLAYER_EXTRA)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState!=null)
        {
            player=intent.getParcelableExtra(PLAYER_EXTRA)
        }
    }
    fun selectLevel(view: View)
    {
        val selectable = view.id
        when(selectable)
        {
            R.id.beginner ->{
                advanced.isChecked=false
                player.skill="Beginner"
            }
            R.id.advanced ->
            {
                beginner.isChecked=false
                player.skill="Advanced"
            }
        }

    }
    fun callFinish(view:View)
    {
        if(player.skill!="")
        {
            val finalIntent = Intent(this,FinalActivity::class.java)
            finalIntent.putExtra(PLAYER_EXTRA,player)
            startActivity(finalIntent)
        }
        else
        {
            Toast.makeText(this,"Please Select A Skill",Toast.LENGTH_SHORT).show()
        }

}

}

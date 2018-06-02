package com.example.jon_snow.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.jon_snow.swoosh.Model.Player

import com.example.jon_snow.swoosh.R
import com.example.jon_snow.swoosh.Utilities.PLAYER_EXTRA
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player()
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(PLAYER_EXTRA,player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState !=null)
        {
            player=savedInstanceState.getParcelable(PLAYER_EXTRA)
        }
    }



        fun selectLeague(view: View)
        {
            val selected = view.id
            when(selected)
            {
              R.id.men ->{women.isChecked=false
                    co_ed.isChecked=false
                  player.league="Men"
                    }
              R.id.women ->{men.isChecked=false
                      co_ed.isChecked=false
                  player.league="Women"}
              R.id.co_ed ->{
                  men.isChecked=false
                  women.isChecked=false
                  player.league="Co-Ed"

              }
            }
        }

        fun moveToSkill(view:View)
        {   if(player.league!="") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(PLAYER_EXTRA,player)
            startActivity(skillIntent)
        }
            else
        {
            Toast.makeText(this,"Please Select A Category",Toast.LENGTH_SHORT).show()
        }
        }

}

package com.example.jon_snow.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

        fun selectLeague(view: View)
        {
            val selected = view.id
            when(selected)
            {
              R.id.men->{women.isChecked=false
                    co_ed.isChecked=false
                  selectedLeague="Men"
                    }
              R.id.women->{men.isChecked=false
                      co_ed.isChecked=false
                  selectedLeague="Women"}
              R.id.co_ed->{
                  men.isChecked=false
                  women.isChecked=false
                  selectedLeague="Co-Ed"

              }
            }
        }

        fun moveToSkill(view:View)
        {   if(selectedLeague!="") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(LEAGUE_EXTRA,selectedLeague)
            startActivity(skillIntent)
        }
            else
        {
            Toast.makeText(this,"Please Select A Category",Toast.LENGTH_SHORT).show()
        }
        }

}

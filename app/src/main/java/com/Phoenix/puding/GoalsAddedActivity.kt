package com.Phoenix.puding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.Phoenix.puding.databinding.ActivityAddGoalsBinding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_add_goals.*

class GoalsAddedActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView
    lateinit var timeBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_added)

        timeBtn = findViewById(R.id.middle_container_colored3)

        timeBtn.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(this, EditGoalsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.navigation_work
    }

    fun backbtn(view: View){
        finish()
    }

}
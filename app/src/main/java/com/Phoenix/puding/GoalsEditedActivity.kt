package com.Phoenix.puding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class GoalsEditedActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_edited)

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.navigation_work

        bottomNavigationView.setOnItemSelectedListener { item->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.v("", "click")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_work -> {
                    true
                }
                R.id.navigation_shop -> {
                    true
                }
                else -> {
                    true
                }
            }
            true
        }
    }

    fun backbtn(view: View){
        finish()
    }
}
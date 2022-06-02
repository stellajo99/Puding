package com.Phoenix.puding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GoalsEditedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_edited)
    }

    fun backbtn(view: View){
        finish()
    }
}
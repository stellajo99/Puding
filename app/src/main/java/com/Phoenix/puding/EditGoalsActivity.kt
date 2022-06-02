package com.Phoenix.puding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class EditGoalsActivity : AppCompatActivity() {

    lateinit var enterBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_goals)

        enterBtn = findViewById(R.id.delete_container)

        enterBtn.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(this, SetGoalsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })

    }

    fun backbtn(view: View){
        finish()
    }
}
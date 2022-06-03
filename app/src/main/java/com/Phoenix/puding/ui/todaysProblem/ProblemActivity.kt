package com.Phoenix.puding.ui.todaysProblem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.Phoenix.puding.MainActivity
import com.Phoenix.puding.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProblemActivity: AppCompatActivity() {
    lateinit var backBtn: ImageView
    lateinit var probTime1: ImageButton
    lateinit var probTime2: ImageButton
    lateinit var probTime3: ImageButton
    lateinit var probNum1: ImageButton
    lateinit var probNum2: ImageButton
    lateinit var probNum3: ImageButton

    lateinit var todaysProblem: TextView
    lateinit var date: TextView
    lateinit var probLeftNum: TextView
    lateinit var probLeftTxt: TextView

    lateinit var DateCont: ImageView

    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_prob)

        backBtn = findViewById(R.id.back)
        probTime1 = findViewById(R.id.problem_time1)
        probTime2 = findViewById(R.id.problem_time2)
        probTime3 = findViewById(R.id.problem_time3)
        probNum1 = findViewById(R.id.problem_num1)
        probNum2 = findViewById(R.id.problem_num2)
        probNum3 = findViewById(R.id.problem_num3)

        todaysProblem = findViewById(R.id.text_Todays_Problem)
        date = findViewById(R.id.date)
        probLeftNum = findViewById(R.id.prob_left_num)
        probLeftTxt = findViewById(R.id.prob_left_text)

        DateCont = findViewById(R.id.date_container)

        probTime1.setOnClickListener {
            var intent = Intent(this, ConfActivity::class.java)
            intent.putExtra("problem_number", "2559")
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        probNum1.setOnClickListener {
            var intent = Intent(this, ConfActivity::class.java)
            intent.putExtra("problem_number", "2559")
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        probTime2.setOnClickListener {
            var intent = Intent(this, ConfActivity::class.java)
            intent.putExtra("problem_number", "2560")
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        probNum2.setOnClickListener {
            var intent = Intent(this, ConfActivity::class.java)
            intent.putExtra("problem_number", "2560")
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        probTime3.setOnClickListener {
            var intent = Intent(this, ConfActivity::class.java)
            intent.putExtra("problem_number", "2561")
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        probNum3.setOnClickListener {
            var intent = Intent(this, ConfActivity::class.java)
            intent.putExtra("problem_number", "2561")
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
        backBtn.setOnClickListener{
            val intent = Intent(this, ConfActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.navigation_work

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
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
        }
    }
}
package com.Phoenix.puding.ui.todaysProblem

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.Phoenix.puding.R
import android.content.Intent
import android.net.Uri;
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Problem: AppCompatActivity() {
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

        todaysProblem = findViewById(R.id.todays_problem_text)
        date = findViewById(R.id.date)
        probLeftNum = findViewById(R.id.prob_left_num)
        probLeftTxt = findViewById(R.id.prob_left_text)

        DateCont = findViewById(R.id.date_container)

        probTime1.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2557"))
            startActivity(intent)
        }
        probNum1.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2557"))
            startActivity(intent)
        }
        probTime2.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2558"))
            startActivity(intent)
        }
        probNum2.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2557"))
            startActivity(intent)
        }
        probTime3.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2558"))
            startActivity(intent)
        }
        probNum3.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2557"))
            startActivity(intent)
        }
    }
}
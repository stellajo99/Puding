package com.Phoenix.puding.ui.todaysProblem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.Phoenix.puding.MainActivity
import com.Phoenix.puding.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_conf.*

class ConfActivity: AppCompatActivity() {
    lateinit var backBtn: ImageView
    lateinit var probNameBtn: ImageView
    lateinit var probNumBtn: ImageButton
    lateinit var imgUploadBtn: ImageButton
    lateinit var imgUploadBtn2: ImageButton

    lateinit var todaysProblemName: TextView
    lateinit var todaysProblemnum: TextView

    lateinit var uploadedImg: ImageView

    lateinit var problem_number: String

    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_conf)

        backBtn = findViewById(R.id.back)
        probNameBtn = findViewById(R.id.problem_name)
        probNumBtn = findViewById(R.id.problem_num)
        imgUploadBtn = findViewById(R.id.img_upload_button)
        imgUploadBtn2 = findViewById(R.id.img_upload_button2)

        todaysProblemName = findViewById(R.id.todays_problem_name)
        todaysProblemnum = findViewById(R.id.todays_problem_num)

        uploadedImg = findViewById(R.id.img_profile)

        var intent = getIntent()
        problem_number = intent.getStringExtra("problem_number").toString()
        todaysProblemnum.text = "#" + problem_number
        if(problem_number == "2559"){
            todaysProblemName.text = "수열"
        }
        else if(problem_number == "2560"){
            todaysProblemName.text = "짚신벌레"
        }
        else if(problem_number == "2561"){
            todaysProblemName.text = "세 번 뒤집기"
        }

        probNameBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/" + problem_number))
            startActivity(intent)
        }
        probNumBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/" + problem_number))
            startActivity(intent)
        }

        imgUploadBtn.setOnClickListener {

        }

        backBtn.setOnClickListener{
            val intent = Intent(this, ProblemActivity::class.java)
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
package com.Phoenix.puding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.Phoenix.puding.databinding.ActivityAddGoalsBinding
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.Phoenix.puding.databinding.ActivityMainBinding
import com.Phoenix.puding.ui.home.HomeFragment
import com.Phoenix.puding.ui.work.WorkFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_add_goals.*



class AddGoalsActivity : AppCompatActivity() {
    lateinit var enterBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_goals)

        setupSpinnerHour()
        setupSpinnerMinute()
        setupSpinnerRepeat()
        setupSpinnerProb()

        enterBtn = findViewById(R.id.enter_container)

        enterBtn.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(this, GoalsAddedActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })


    }

    private fun setupSpinnerHour() {
        val hours = resources.getStringArray(R.array.hours)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, hours)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        hour_spinner.adapter = adapter
    }

    private fun setupSpinnerMinute() {
        val minutes = resources.getStringArray(R.array.minutes)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, minutes)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        minute_spinner.adapter = adapter
    }

    private fun setupSpinnerRepeat() {
        val repeats = resources.getStringArray(R.array.repeat)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, repeats)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        repeat_choice.adapter = adapter
    }

    private fun setupSpinnerProb() {
        val probs = resources.getStringArray(R.array.problem)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, probs)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        prob_choice.adapter = adapter
    }

    private fun setupSpinnerHandler() {
        hour_spinner.setSelection(1)
        hour_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        minute_spinner.setSelection(1)
        minute_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        repeat_choice.setSelection(1)
        repeat_choice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        prob_choice.setSelection(1)
        prob_choice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }


    fun backbtn(view: View){
        finish()
    }

    fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment).commit()
    }
}
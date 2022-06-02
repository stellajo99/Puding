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

class EditGoalsActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView
    lateinit var enterBtn : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_goals)

        setupSpinnerHour()
        setupSpinnerMinute()
        setupSpinnerRepeat()
        setupSpinnerProb()

        enterBtn = findViewById(R.id.enter_container)

        enterBtn.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(this, GoalsEditedActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.navigation_work
    }

    private fun setupSpinnerHour() {
        val hours = resources.getStringArray(R.array.hours)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, hours)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        hour_spinner.adapter = adapter
        hour_spinner.setSelection(12)
    }

    private fun setupSpinnerMinute() {
        val minutes = resources.getStringArray(R.array.minutes)
        val adapter = ArrayAdapter(this, R.layout.spinner_item, minutes)
        adapter.setDropDownViewResource(R.layout.spinner_item)
        minute_spinner.adapter = adapter
        minute_spinner.setSelection(0)
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
        prob_choice.setSelection(4)
    }

    private fun setupSpinnerHandler() {
        hour_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        minute_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        repeat_choice.setSelection(1)
        repeat_choice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        prob_choice.setSelection(1)
        prob_choice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    fun backbtn(view: View){
        finish()
    }
}
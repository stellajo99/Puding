package com.Phoenix.puding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.Phoenix.puding.R
import com.Phoenix.puding.databinding.FragmentWorkBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class SetGoalsActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView
    lateinit var plus_goal : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_goals)

        plus_goal = findViewById(R.id.addgoals)


        plus_goal.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(this, AddGoalsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.navigation_work

        bottomNavigationView.setOnItemSelectedListener { item->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Log.v("", "click")
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
            true
        }
    }

    fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment).commit()
    }

    fun backbtn(view: View){
        finish()
    }


}

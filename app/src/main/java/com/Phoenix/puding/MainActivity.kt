package com.Phoenix.puding

import android.content.res.ColorStateList
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.Phoenix.puding.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var hungryBar: ProgressBar
    lateinit var  funBar: ProgressBar
    lateinit var puppy: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_work, R.id.navigation_shop, R.id.navigation_user))

        navView.setupWithNavController(navController)

        //bind view
        hungryBar = findViewById(R.id.hungerBar)
        funBar = findViewById(R.id.funBar)
        puppy = findViewById(R.id.puppy)

        val timerTask: TimerTask = object : TimerTask() {
            override fun run() {
                runOnUiThread() {
                    decreaseBar()
                }
            }
        }

        var timer: Timer = Timer()
        timer.schedule(timerTask, 0, 1000)
    }

    fun decreaseBar() {
        hungryBar.incrementProgressBy(-2)
        funBar.incrementProgressBy(-1)
        if (hungryBar.progress < 0)
            hungryBar.progress = 0
        if (funBar.progress < 0)
            funBar.progress = 0

        if(hungryBar.progress >= 70) {
            hungryBar.progressTintList = ColorStateList.valueOf(resources.getColor(R.color.bar_good))
        }
        else if(hungryBar.progress > 35){
            hungryBar.progressTintList = ColorStateList.valueOf(resources.getColor(R.color.bar_soso))
        }
        else{
            hungryBar.progressTintList = ColorStateList.valueOf(resources.getColor(R.color.bar_danger))
        }

        if(funBar.progress >= 70) {
            funBar.progressTintList = ColorStateList.valueOf(resources.getColor(R.color.bar_good))
        }
        else if(funBar.progress > 35){
            funBar.progressTintList = ColorStateList.valueOf(resources.getColor(R.color.bar_soso))
        }
        else{
            funBar.progressTintList = ColorStateList.valueOf(resources.getColor(R.color.bar_danger))
        }
        checkPuppy()
    }

    fun checkPuppy(){
        if(hungryBar.progress >= 70 && funBar.progress >= 70){
            puppy.setImageResource(R.drawable.happy_puppy)
        }
        else if(hungryBar.progress < 35 || funBar.progress < 35){
            puppy.setImageResource(R.drawable.bad_puppy)
        }
        else{
            puppy.setImageResource(R.drawable.soso_puppy)
        }
    }

    fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main,fragment).commit()
    }

    fun openPuppyContainer(){
        var puppyContainer = findViewById<ImageView>(R.id.pet_container)
        var puppy = findViewById<ImageView>(R.id.puppy)

        puppyContainer.visibility = View.VISIBLE
        puppy.visibility = View.VISIBLE
    }

    fun closePuppyContainer(){
        var puppyContainer = findViewById<ImageView>(R.id.pet_container)
        var puppy = findViewById<ImageView>(R.id.puppy)

        puppyContainer.visibility = View.INVISIBLE
        puppy.visibility = View.INVISIBLE
    }

    fun getCoin(): Int{
        var coin = findViewById<TextView>(R.id.coin)

        return Integer.parseInt(coin.text.toString())
    }

    fun useCoin(value: Int){
        var coin = findViewById<TextView>(R.id.coin)
        var currentValue = Integer.parseInt(coin.text.toString())
        currentValue -= value

        coin.text = currentValue.toString()
    }

    fun incHunger(value: Int){
        findViewById<ProgressBar>(R.id.hungerBar).progress += value
    }

    fun incFun(value: Int){
        findViewById<ProgressBar>(R.id.funBar).progress += value
    }
}
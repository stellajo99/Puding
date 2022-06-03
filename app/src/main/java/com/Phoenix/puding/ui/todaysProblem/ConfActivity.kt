package com.Phoenix.puding.ui.todaysProblem

import android.content.Intent
import android.net.Uri
import android.net.Uri.decode
import android.os.Bundle
import android.util.Base64.decode
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
import java.lang.Byte.decode
import java.lang.Integer.decode
import java.lang.Short.decode
import java.util.*
import java.net.URLDecoder.decode
import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Build
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.getBitmap
import android.util.Base64
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class ConfActivity: AppCompatActivity() {
    lateinit var backBtn: ImageView
    lateinit var probNameBtn: ImageView
    lateinit var probNumBtn: ImageButton
    lateinit var imgUploadBtn: ImageButton
    lateinit var imgUploadBtn2: ImageButton

    lateinit var todaysProblemName: TextView
    lateinit var todaysProblemnum: TextView
    lateinit var information: TextView

    lateinit var uploadedImg: ImageView
    lateinit var bitmap: Bitmap
    var check = false

    lateinit var problem_number: String

    lateinit var bottomNavigationView : BottomNavigationView

    lateinit var submitButton: ImageView
    lateinit var coinPopup: ImageView
    lateinit var getButton: ImageView

    lateinit var preference: SharedPreferences

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
        information = findViewById(R.id.click_ment)

        uploadedImg = findViewById(R.id.img_profile)

        submitButton = findViewById(R.id.submit_button)
        coinPopup = findViewById(R.id.coin_popup)
        getButton = findViewById(R.id.get_button)

        preference = getSharedPreferences("information", MODE_PRIVATE)

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

        backBtn.setOnClickListener{
            click_ment.visibility = View.VISIBLE
            val intent = Intent(this, ProblemActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        submitButton.setOnClickListener{
            coinPopup.visibility = View.VISIBLE
            getButton.visibility = View.VISIBLE
        }

        preference.edit().putBoolean("2559", false).apply()
        preference.edit().putBoolean("2560", false).apply()
        preference.edit().putBoolean("2561", false).apply()
        preference.edit().putString("coin", "100").apply()
        preference.edit().putBoolean("done", false).apply()
        getButton.setOnClickListener{
            preference.edit().putBoolean(problem_number, true).apply()
            var coin = (Integer.parseInt(preference.getString("coin", "100")) + 50).toString()
            preference.edit().putString("coin", coin).apply()
            preference.edit().putBoolean("done", true).apply()
            var intent = Intent(this, ProblemActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        bottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigationView.selectedItemId = R.id.navigation_work

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    click_ment.visibility = View.VISIBLE
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

        var encoded = "encoded"
        var imageAsBytes = Base64.decode(encoded, Base64.DEFAULT)

        uploadedImg.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size))

        imgUploadBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    pickImageFromGallery()
                }
            } else {
                pickImageFromGallery()
            }
        }
    }

    private fun pickImageFromGallery(){
        var intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERMISSION_CODE -> {
                if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery()
                }
                else{
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE && data != null){
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data.data!!)
            uploadedImg.setImageBitmap(bitmap)
            click_ment.visibility = View.INVISIBLE
            check = true
        }
    }
}
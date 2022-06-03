package com.Phoenix.puding.ui.todaysProblem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.Phoenix.puding.R
import com.Phoenix.puding.databinding.FragmentConfBinding

class ConfFragment: Fragment() {
    private lateinit var binding: FragmentConfBinding

    lateinit var backBtn: ImageView
    lateinit var probNameBtn: ImageView
    lateinit var probNumBtn: ImageButton
    lateinit var imgUploadBtn: ImageButton
    lateinit var imgUploadBtn2: ImageButton

    lateinit var todaysProblem: TextView

    lateinit var uploadedImg: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_conf, container, false)

        backBtn = v.findViewById(R.id.back)
        probNameBtn = v.findViewById(R.id.problem_name)
        probNumBtn = v.findViewById(R.id.problem_num)
        imgUploadBtn = v.findViewById(R.id.img_upload_button)
        imgUploadBtn2 = v.findViewById(R.id.img_upload_button2)

        todaysProblem = v.findViewById(R.id.todays_problem_text)

        uploadedImg = v.findViewById(R.id.img_profile)

        probNameBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2557"))
            startActivity(intent)
        }
        probNumBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.acmicpc.net/problem/2557"))
            startActivity(intent)
        }

        imgUploadBtn.setOnClickListener {

        }

        return v
    }
}
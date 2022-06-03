package com.Phoenix.puding.ui.work

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.Phoenix.puding.MainActivity
import com.Phoenix.puding.R
import com.Phoenix.puding.SetGoalsActivity
import com.Phoenix.puding.databinding.FragmentWorkBinding
import com.Phoenix.puding.ui.home.HomeFragment
import com.Phoenix.puding.ui.todaysProblem.Problem
import com.Phoenix.puding.ui.todaysProblem.ProblemActivity


class WorkFragment : Fragment()  {

    private var _binding: FragmentWorkBinding? = null
    lateinit var add_goal : ImageButton
    lateinit var solve_problem : ImageButton
    lateinit var closeTabButton: ImageView
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View {
        val workViewModel =
                ViewModelProvider(this).get(WorkViewModel::class.java)

        _binding = FragmentWorkBinding.inflate(inflater, container, false)
        val root: View = binding.root
        add_goal = root.findViewById(R.id.add_note)
        solve_problem = root.findViewById(R.id.todo)
        closeTabButton = root.findViewById(R.id.down)
//        val textView: TextView = binding.textWork
//        workViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        add_goal.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(activity, SetGoalsActivity::class.java) //fragment라서 activity intent와는 다른 방식
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })

        solve_problem.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(activity, ProblemActivity::class.java) //fragment라서 activity intent와는 다른 방식
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        })

        closeTabButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(HomeFragment())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
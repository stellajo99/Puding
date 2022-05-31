package com.Phoenix.puding.ui.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.Phoenix.puding.MainActivity
import com.Phoenix.puding.R
import com.Phoenix.puding.databinding.FragmentShopBinding
import com.Phoenix.puding.ui.home.HomeFragment

class ShopFragment : Fragment() {
    lateinit var foodTabButton: Button
    lateinit var toyTabButton: Button
    lateinit var closeTabButton: Button

    lateinit var foodInventory: ScrollView
    lateinit var toyInventory: ScrollView

    lateinit var foodTab: ImageView
    lateinit var toyTab: ImageView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_shop, container, false)

        foodTabButton = v.findViewById(R.id.food_tab_button)
        toyTabButton = v.findViewById(R.id.toy_tab_button)
        closeTabButton = v.findViewById(R.id.close_tab_button)

        foodInventory = v.findViewById(R.id.food_inventory)
        toyInventory = v.findViewById(R.id.toy_inventory)

        foodTab = v.findViewById(R.id.food_tab)
        toyTab = v.findViewById(R.id.toy_tab)

        foodTabButton.setOnClickListener{
            foodTabButton.visibility = View.INVISIBLE
            toyTabButton.visibility = View.VISIBLE
            foodInventory.visibility = View.VISIBLE
            toyInventory.visibility = View.INVISIBLE
            foodTab.visibility = View.VISIBLE
            toyTab.visibility = View.INVISIBLE
        }

        toyTabButton.setOnClickListener{
            foodTabButton.visibility = View.VISIBLE
            toyTabButton.visibility = View.INVISIBLE
            foodInventory.visibility = View.INVISIBLE
            toyInventory.visibility = View.VISIBLE
            foodTab.visibility = View.INVISIBLE
            toyTab.visibility = View.VISIBLE
        }

        closeTabButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(HomeFragment())
        }

        return v
    }
}
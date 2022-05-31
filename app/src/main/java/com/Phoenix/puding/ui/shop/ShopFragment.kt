package com.Phoenix.puding.ui.shop

import android.media.Image
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
import org.w3c.dom.Text

class ShopFragment : Fragment() {
    lateinit var foodTabButton: Button
    lateinit var toyTabButton: Button
    lateinit var closeTabButton: Button

    lateinit var foodInventory: ScrollView
    lateinit var toyInventory: ScrollView

    lateinit var foodTab: ImageView
    lateinit var toyTab: ImageView

    lateinit var popup: ImageView
    lateinit var popup_img: ImageView
    lateinit var popup_coin: TextView
    lateinit var popup_value: TextView
    lateinit var popup_cancle: Button
    lateinit var popup_buy: Button

    lateinit var food1: ImageView
    lateinit var food2: ImageView
    lateinit var food3: ImageView
    lateinit var food4: ImageView
    lateinit var food5: ImageView
    lateinit var food6: ImageView

    lateinit var toy1: ImageView
    lateinit var toy2: ImageView
    lateinit var toy3: ImageView
    lateinit var toy4: ImageView
    lateinit var toy5: ImageView
    lateinit var toy6: ImageView

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_shop, container, false)

        foodTabButton = v.findViewById(R.id.food_tab_button)
        toyTabButton = v.findViewById(R.id.toy_tab_button)
        closeTabButton = v.findViewById(R.id.close_tab_button)

        foodInventory = v.findViewById(R.id.food_inventory)
        toyInventory = v.findViewById(R.id.toy_inventory)

        foodTab = v.findViewById(R.id.food_tab)
        toyTab = v.findViewById(R.id.toy_tab)

        popup = v.findViewById(R.id.inventory_popup)
        popup_img = v.findViewById(R.id.popup_img)
        popup_coin = v.findViewById(R.id.popup_coin)
        popup_value = v.findViewById(R.id.popup_value)
        popup_cancle = v.findViewById(R.id.inventory_popup_cancle)
        popup_buy = v.findViewById(R.id.inventory_popup_buy)

        food1 = v.findViewById(R.id.food1)
        food2 = v.findViewById(R.id.food2)
        food3 = v.findViewById(R.id.food3)
        food4 = v.findViewById(R.id.food4)
        food5 = v.findViewById(R.id.food5)
        food6 = v.findViewById(R.id.food6)

        toy1 = v.findViewById(R.id.toy1)
        toy2 = v.findViewById(R.id.toy2)
        toy3 = v.findViewById(R.id.toy3)
        toy4 = v.findViewById(R.id.toy4)
        toy5 = v.findViewById(R.id.toy5)
        toy6 = v.findViewById(R.id.toy6)

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
            (activity as MainActivity).openPuppyContainer()
        }

        food1.setOnClickListener{
            OpenFoodPopUp(1)
        }
        food2.setOnClickListener{
            OpenFoodPopUp(2)
        }
        food3.setOnClickListener{
            OpenFoodPopUp(3)
        }
        food4.setOnClickListener{
            OpenFoodPopUp(4)
        }
        food5.setOnClickListener{
            OpenFoodPopUp(5)
        }
        food6.setOnClickListener{
            OpenFoodPopUp(6)
        }

        toy1.setOnClickListener{
            OpenToyPopUp(1)
        }
        toy2.setOnClickListener{
            OpenToyPopUp(2)
        }
        toy3.setOnClickListener{
            OpenToyPopUp(3)
        }
        toy4.setOnClickListener{
            OpenToyPopUp(4)
        }
        toy5.setOnClickListener{
            OpenToyPopUp(5)
        }
        toy6.setOnClickListener{
            OpenToyPopUp(6)
        }

        popup_cancle.setOnClickListener {
            closePopup()
        }

        popup_buy.setOnClickListener {
            buyItem()
        }

        return v
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).openPuppyContainer()
    }

    fun OpenFoodPopUp(num: Int){
        closePopup()
        (activity as MainActivity).closePuppyContainer()

        popup.setImageResource(R.drawable.food_inventory_popup)
        popup.visibility = View.VISIBLE
        popup.tag = "food"
        popup_cancle.visibility = View.VISIBLE
        popup_buy.visibility = View.VISIBLE

        when(num){
            1 -> {
                popup_img.setImageResource(R.drawable.raw_food1)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "10"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "10"
                popup_value.visibility = View.VISIBLE
            }
            2 -> {
                popup_img.setImageResource(R.drawable.raw_food2)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "20"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "30"
                popup_value.visibility = View.VISIBLE
            }
            3 -> {
                popup_img.setImageResource(R.drawable.raw_food3)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "32"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "50"
                popup_value.visibility = View.VISIBLE
            }
            4 -> {
                popup_img.setImageResource(R.drawable.raw_food4)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "35"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "55"
                popup_value.visibility = View.VISIBLE
            }
            5 -> {
                popup_img.setImageResource(R.drawable.raw_food5)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "38"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "60"
                popup_value.visibility = View.VISIBLE
            }
            6 -> {
                popup_img.setImageResource(R.drawable.raw_food6)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "150"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "30"
                popup_value.visibility = View.VISIBLE
            }
        }
    }

    fun OpenToyPopUp(num: Int) {
        closePopup()
        (activity as MainActivity).closePuppyContainer()

        popup.setImageResource(R.drawable.toy_inventory_popup)
        popup.visibility = View.VISIBLE
        popup.tag = "toy"
        popup_cancle.visibility = View.VISIBLE
        popup_buy.visibility = View.VISIBLE

        when (num) {
            1 -> {
                popup_img.setImageResource(R.drawable.raw_toy1)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "5"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "5"
                popup_value.visibility = View.VISIBLE
            }
            2 -> {
                popup_img.setImageResource(R.drawable.raw_toy2)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "10"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "15"
                popup_value.visibility = View.VISIBLE
            }
            3 -> {
                popup_img.setImageResource(R.drawable.raw_toy3)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "15"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "25"
                popup_value.visibility = View.VISIBLE
            }
            4 -> {
                popup_img.setImageResource(R.drawable.raw_toy4)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "17"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "30"
                popup_value.visibility = View.VISIBLE
            }
            5 -> {
                popup_img.setImageResource(R.drawable.raw_toy5)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "19"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "35"
                popup_value.visibility = View.VISIBLE
            }
            6 -> {
                popup_img.setImageResource(R.drawable.raw_toy6)
                popup_img.visibility = View.VISIBLE
                popup_coin.text = "200"
                popup_coin.visibility = View.VISIBLE
                popup_value.text = "30"
                popup_value.visibility = View.VISIBLE
            }
        }
    }

    fun closePopup(){
        popup.visibility = View.INVISIBLE
        popup_img.visibility = View.INVISIBLE
        popup_coin.visibility = View.INVISIBLE
        popup_value.visibility = View.INVISIBLE
        popup_cancle.visibility = View.INVISIBLE
        popup_buy.visibility = View.INVISIBLE

        (activity as MainActivity).openPuppyContainer()
    }

    fun buyItem(){
        var coin = (activity as MainActivity).getCoin()

        if(coin >= Integer.parseInt(popup_coin.text.toString())){
            (activity as MainActivity).useCoin(Integer.parseInt(popup_coin.text.toString()))
            if(popup.tag == "food"){
                (activity as MainActivity).incHunger(Integer.parseInt(popup_value.text.toString()))
            }
            else if(popup.tag == "toy"){
                (activity as MainActivity).incFun(Integer.parseInt(popup_value.text.toString()))
            }
        }
        closePopup()
    }
}
package com.jayantx.zomatoclone.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jayantx.zomatoclone.Location.SearchLocation
import com.jayantx.zomatoclone.MainActivity
import com.jayantx.zomatoclone.R
import com.jayantx.zomatoclone.RestaurantNames
import com.jayantx.zomatoclone.deliveryfragmentRV.SmallCardDataClass
import com.jayantx.zomatoclone.deliveryfragmentRV.TopCArdsDataClass
import com.jayantx.zomatoclone.deliveryfragmentRV.TopCardsAdapter
import com.jayantx.zomatoclone.deliveryfragmentRV.TopSmallCardAdapter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.drawer_content_main.*
import kotlinx.android.synthetic.main.fragment_delivery.*

import kotlinx.android.synthetic.main.fragment_delivery.view.*
import java.util.ArrayList


class DeliveryFragment : Fragment() {

    val listOfTopCardItems = ArrayList<TopCArdsDataClass>()
    val listOfSmallCardItems = ArrayList<SmallCardDataClass>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {





        val myDeliveryView =  inflater.inflate(R.layout.fragment_delivery, container, false)

        val rvTopOffers = myDeliveryView.rv_top_offers_delivery_fragment as RecyclerView
        val rvRestaurantNames = myDeliveryView.rv_restaurant_names as RecyclerView
        val rvTopSmallCard = myDeliveryView.rv_top_small_card as RecyclerView



        val search_btn = myDeliveryView.search_btn as EditText

        search_btn.setOnClickListener {
            startActivity(Intent(context, SearchLocation::class.java))

        }


        val restaurantNamesAdapter = GroupAdapter<GroupieViewHolder>()
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())
        restaurantNamesAdapter.add(RestaurantNames())

        rvRestaurantNames.adapter = restaurantNamesAdapter
        rvRestaurantNames.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)





        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))
        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))
        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))
        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))
        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))
        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))
        listOfTopCardItems.add(TopCArdsDataClass("HYGIENE\nFIRST","BEST IN CLASS HYGIENIC\nOUTLETS",R.color.black ))

        val topCardAdapter = TopCardsAdapter(context!!,listOfTopCardItems)
        rvTopOffers.adapter = topCardAdapter
        rvTopOffers.layoutManager  = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))
        listOfSmallCardItems.add(SmallCardDataClass(R.drawable.location_pointer, "pointer"))

        val smallCardAdapter = TopSmallCardAdapter(context!!,listOfSmallCardItems)
        rvTopSmallCard.adapter = smallCardAdapter
        rvTopSmallCard.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)



        return myDeliveryView
    }






}

package com.jayantx.zomatoclone.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jayantx.zomatoclone.Location.SearchLocation
import com.jayantx.zomatoclone.R
import com.jayantx.zomatoclone.TopOfferRVClass
import com.jayantx.zomatoclone.TopSmallCard
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.fragment_delivery.view.*



class DeliveryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val myDeliveryView =  inflater.inflate(R.layout.fragment_delivery, container, false)

        val rvTopOffers = myDeliveryView.rv_top_offers_delivery_fragment as RecyclerView
        val rvTopSmallCards = myDeliveryView.rv_top_small_cards as RecyclerView

        val search_btn = myDeliveryView.search_btn as Button

        search_btn.setOnClickListener {
            startActivity(Intent(context, MapsFragmentActivity::class.java))

        }

        val adapter = GroupAdapter<GroupieViewHolder>()


        adapter.add(TopOfferRVClass())
        adapter.add(TopOfferRVClass())
        adapter.add(TopOfferRVClass())
        adapter.add(TopOfferRVClass())
        adapter.add(TopOfferRVClass())

        rvTopOffers.adapter = adapter
        rvTopOffers.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        adapter.add(TopSmallCard())
        adapter.add(TopSmallCard())
        adapter.add(TopSmallCard())


        rvTopSmallCards.adapter = adapter
        rvTopSmallCards.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        return myDeliveryView
    }






}

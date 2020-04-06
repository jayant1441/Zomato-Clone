package com.jayantx.zomatoclone

import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class RestaurantNames() : Item<GroupieViewHolder>(){
    override fun getLayout(): Int = R.layout.restaurants_names_delivery_fragment

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

}
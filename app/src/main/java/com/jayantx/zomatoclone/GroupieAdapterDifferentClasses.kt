package com.jayantx.zomatoclone

import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class TopOfferRVClass : Item<GroupieViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.card_top_offers_rv_delivery
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

}


class TopSmallCard() : Item<GroupieViewHolder>(){
    override fun getLayout(): Int = R.layout.restaurants_names_delivery_fragment

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
    }

}
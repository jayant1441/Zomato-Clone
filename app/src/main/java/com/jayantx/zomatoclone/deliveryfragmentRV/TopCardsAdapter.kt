package com.jayantx.zomatoclone.deliveryfragmentRV

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jayantx.zomatoclone.R
import kotlinx.android.synthetic.main.card_top_offers_rv_delivery.view.*

class TopCardsAdapter (var context:Context, var listOfTopCards: ArrayList<TopCArdsDataClass>): RecyclerView.Adapter<TopCardsAdapter.topCardsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): topCardsViewHolder {
        return topCardsViewHolder(LayoutInflater.from(context).inflate(R.layout.card_top_offers_rv_delivery,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfTopCards.size
    }

    override fun onBindViewHolder(holder: topCardsViewHolder, position: Int) {


    }

    inner class topCardsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_top_card_title = itemView.tv_top_card_title as TextView
        val tv_top_card_des = itemView.tv_top_card_des as TextView
        val cv_top_card_background = itemView.cv_top_card_background as ConstraintLayout

    }


}

data class TopCArdsDataClass(var topCardTitle: String?, var topCardDes: String?, var topCardBackground: Int?)
//TODO(changing topCardBAckground to string)
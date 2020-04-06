package com.jayantx.zomatoclone.deliveryfragmentRV

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jayantx.zomatoclone.R
import kotlinx.android.synthetic.main.rv_top_small_card_delivery_fragment.view.*

class TopSmallCardAdapter(var context: Context, var listOfSmallCardItems: ArrayList<SmallCardDataClass>) : RecyclerView.Adapter<TopSmallCardAdapter.SmallCardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallCardViewHolder {
        return SmallCardViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_top_small_card_delivery_fragment,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfSmallCardItems.size
    }

    override fun onBindViewHolder(holder: SmallCardViewHolder, position: Int) {

    }


    inner class SmallCardViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var iv_top_small_card = itemView.iv_top_small_card as ImageView
        var tv_top_small_card = itemView.tv_top_small_card as TextView

    }

}

data class SmallCardDataClass(var topCardImage: Int?, var topCardTitle: String?)
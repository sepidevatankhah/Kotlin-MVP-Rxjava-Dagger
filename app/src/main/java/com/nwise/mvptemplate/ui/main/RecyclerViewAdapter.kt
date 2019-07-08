package com.nwise.mvptemplate.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nwise.mvptemplate.R
import com.nwise.mvptemplate.domain.models.Answer
import com.nwise.mvptemplate.domain.models.ListWrapper
import kotlinx.android.synthetic.main.odd_selectable_list_item.view.*

class RecyclerViewAdapter(private val data: ListWrapper<Answer>, private val context: Context) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private var itemViewType: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(itemViewType, viewGroup, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val answer = data.items!![position]
        holder.text.text = answer.toString()
        holder.itemView.tag = answer.answerId
        Glide.with(context).load(answer.owner!!.profileImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return data.items!!.size
    }

    class MyViewHolder(V: View) : RecyclerView.ViewHolder(V) {
         val text: TextView by lazy {V.text1}
         val imageView: ImageView by lazy {V.img_avator}
    }

    override fun getItemViewType(position: Int): Int {
        itemViewType = if (position % 5 == 0) {
            R.layout.odd_selectable_list_item
        } else
            R.layout.even_selectable_list_item

        return itemViewType
    }
}

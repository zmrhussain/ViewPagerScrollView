package com.example.viewpagerscrollview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(
    private val quotes : List<String>
    ) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>()
{

    inner class ViewPagerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        //val curQuote = quotes[position]
        val curQuote = quotes[position%quotes.size]
        holder.itemView.ivText.setText(curQuote)
    }

    override fun getItemCount(): Int {
        //return quotes.size
        return Int.MAX_VALUE
    }



}
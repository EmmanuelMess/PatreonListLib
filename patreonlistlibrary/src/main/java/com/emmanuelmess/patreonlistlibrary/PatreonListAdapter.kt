package com.emmanuelmess.patreonlistlibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_backer.view.*

class PatreonListAdapter(
    context: Context,
    val listItems: List<BackerItem>
) : RecyclerView.Adapter<PatreonListAdapter.BackerViewHolder>() {
    companion object {
        const val ITEM_TYPE = 0
    }

    val viewInflater = LayoutInflater.from(context)

    override fun getItemViewType(position: Int): Int {
        return ITEM_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackerViewHolder {
        val containerView = viewInflater.inflate(R.layout.item_backer, parent, false) as ViewGroup
        return BackerViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: BackerViewHolder, position: Int) {
        holder.itemView.backerNameTextView.text = listItems[position].backer.name
    }

    override fun getItemCount(): Int = listItems.size

    class BackerViewHolder(view: ViewGroup): RecyclerView.ViewHolder(view)
}
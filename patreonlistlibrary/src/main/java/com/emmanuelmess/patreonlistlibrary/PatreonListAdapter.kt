package com.emmanuelmess.patreonlistlibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_backer.view.*

class PatreonListAdapter(
    context: Context,
    val listItems: List<BackerItem>
) : ArrayAdapter<BackerItem>(context, R.layout.item_backer, R.id.backerNameTextView, listItems) {
/*TODO
    companion object {
        const val ITEM_TYPE = 0;
    }

    override fun getViewTypeCount(): Int = 1

    override fun getItemViewType(position: Int): Int {
        return ITEM_TYPE
    }
*/
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val containerView = super.getView(position, convertView, parent)

        containerView.backerNameTextView.text = getItem(position).backer.name

        return containerView
    }

    override fun getItem(position: Int): BackerItem {
        return listItems[position]
    }

    override fun getCount(): Int = listItems.size

}
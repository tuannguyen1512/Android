package com.example.gmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView


class GmailAdapter(val items: ArrayList<Mail_item>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {

        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        var viewHolder: ViewHolder
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.itemview, parent, false)
            viewHolder = ViewHolder(itemView)
            itemView.tag = viewHolder
        } else {
            itemView = convertView
            viewHolder = itemView.tag as ViewHolder
        }
        viewHolder.receiver.text = items[position].receiver
        viewHolder.title.text = items[position].title
        viewHolder.time.text = items[position].time.hour.toString() +
                ":" + items[position].time.minute.toString() + " PM"
        viewHolder.context.text = items[position].context

        viewHolder.userImg.setImageResource(items[position].imageThumb)
        viewHolder.checkSelected.isChecked = items[position].selected

        if (items[position].selected) {
            viewHolder.checkSelected.setButtonDrawable(android.R.drawable.btn_star_big_on)
        } else
            viewHolder.checkSelected.setButtonDrawable(android.R.drawable.btn_star_big_off)

        viewHolder.checkSelected.setOnClickListener {
            items[position].selected = (it as CheckBox).isChecked
            if (items[position].selected) {
                viewHolder.checkSelected.setButtonDrawable(android.R.drawable.btn_star_big_on)
            } else
                viewHolder.checkSelected.setButtonDrawable(android.R.drawable.btn_star_big_off)
//            else
            notifyDataSetChanged()
        }
        return itemView
    }

    class ViewHolder(itemView: View) {
        var receiver: TextView
        var userImg: ImageView
        var checkSelected: CheckBox
        var title: TextView
        var context: TextView
        var time: TextView

        init {
            receiver = itemView.findViewById(R.id.receiver)
            userImg = itemView.findViewById(R.id.avatar)
            checkSelected = itemView.findViewById(R.id.checked)
            title = itemView.findViewById(R.id.title)
            context = itemView.findViewById(R.id.context)
            time = itemView.findViewById(R.id.time)
        }

    }

}


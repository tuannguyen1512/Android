package com.example.phonebook2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(context: Context, contacts: List<ItemModel>) :
    ArrayAdapter<ItemModel>(context, R.layout.list_item, contacts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item, parent, false)

        val imageViewContact: ImageView = itemView.findViewById(R.id.contact_img)
        val textViewContactName: TextView = itemView.findViewById(R.id.contact_name)

        val contact = getItem(position)

        imageViewContact.setImageResource(contact?.profileImg ?: R.drawable.img)
        textViewContactName.text = contact?.nameAcc

        return itemView
    }
}
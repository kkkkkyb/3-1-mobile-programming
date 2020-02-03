package com.example.admin.content

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.admin.R

class ContentAdapter(val context: Context): BaseAdapter() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return ContentData.values().size
    }

    override fun getItem(position: Int) = ContentData.values() [position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if(convertView != null) {
            Log.i("CONVERT-VIEW", "convertView is not null(convertView 사용), position: ${position.toString()}")
        } else {
            Log.i("CONVERT-VIEW", "convertView is null(아이템 생성), position: ${position.toString()}")
        }

        val view = convertView ?: mInflater.inflate(R.layout.content_list, parent, false)

        view.findViewById<TextView>(R.id.text_name).text = getItem(position).itemName
        view.findViewById<TextView>(R.id.text_content).text = getItem(position).itemDate

        return view
    }
}
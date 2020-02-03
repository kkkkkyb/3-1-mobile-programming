package com.example.mobileprogramming.delay_list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mobileprogramming.R

class DelayListAdapter(val context: Context): BaseAdapter() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return DelayListData.values().size
    }

    override fun getItem(position: Int) = DelayListData.values() [position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if(convertView != null) {
            Log.i("CONVERT-VIEW", "convertView is not null(convertView 사용), position: ${position.toString()}")
        } else {
            Log.i("CONVERT-VIEW", "convertView is null(아이템 생성), position: ${position.toString()}")
        }

        val view = convertView ?: mInflater.inflate(R.layout.delay_list, parent, false)

        view.findViewById<TextView>(R.id.text_list_item_name_delay).text = getItem(position).itemName
        view.findViewById<TextView>(R.id.text_list_date).text = getItem(position).itemDate

        return view
    }
}
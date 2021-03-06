package com.example.mobileprogramming.list_rent

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mobileprogramming.R

// 어댑터 클래스 선언
// 어댑터 클래스를 선언하고, 그 안에 뷰홀더 클래스를 선언
// 리사이클러뷰의 어댑터는 RecyclerView.Adapter를 상속하고, <>에 선언된 뷰홀더 클래스를 넣어야 함
class ListviewAdapterRent(val context: Context): BaseAdapter() {
    // 리스트뷰에서 보여줄 아이템 화면의 인플레이션을 위해 LayoutInflater 참조
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    // ItemDataRent의 항목의 갯수를 리스트뷰에게 반환
    override fun getCount(): Int {
        return ItemDataRent.values().size
    }

    // 어댑터에서 관리하는 데이터에서 position에 해당하는 데이터를 객체 형태로 반환
    override fun getItem(position: Int) = ItemDataRent.values() [position]

    // 어댑터에서 관리하는 데이터에서 position에 해당하는 데이터(아이템)의 id값을 반환
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if(convertView != null) {
            Log.i("CONVERT-VIEW", "convertView is not null(convertView 사용), position: ${position.toString()}")
        } else {
            Log.i("CONVERT-VIEW", "convertView is null(아이템 생성), position: ${position.toString()}")
        }

        val view = convertView ?: mInflater.inflate(R.layout.item_list, parent, false)

        view.findViewById<ImageView>(R.id.img_list_item_rent).setImageResource(getItem(position).imageId)
        view.findViewById<TextView>(R.id.text_list_item_name_rent).text = getItem(position).itemName
        view.findViewById<TextView>(R.id.text_list_amount_rent).text = getItem(position).itemAmount

        return view
    }
}
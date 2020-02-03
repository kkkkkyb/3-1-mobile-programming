package com.example.mobileprogramming.reservation_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mobileprogramming.R
import com.example.mobileprogramming.delay_list.DelayListAdapter
import kotlinx.android.synthetic.main.activity_lend_list.*
import kotlinx.android.synthetic.main.delete_page.view.*

class ReservationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_list)

        var adapter = ReservationListAdapter(this)
        listView.adapter = adapter

        supportActionBar?.title = "예약내역"

        listView.setOnItemClickListener { parent, view, position, id ->
            var curItem = adapter.getItem(position)
            Toast.makeText(this, "${curItem.itemName} 삭제", Toast.LENGTH_LONG).show()

            delete()
        }
    }

    fun delete() {
        val cInflater = LayoutInflater.from(this).inflate(R.layout.delete_page, null)

        val cBuilder = AlertDialog.Builder(this).setView(cInflater)

        val cAlertDialog = cBuilder.show()
        cInflater.button3.setOnClickListener{
            cAlertDialog.dismiss()

            Toast.makeText(applicationContext, "확인을 선택했습니다", Toast.LENGTH_LONG).show()

        }
        cInflater.button2.setOnClickListener{
            cAlertDialog.dismiss()

            Toast.makeText(applicationContext, "취소를 선택했습니다", Toast.LENGTH_LONG).show()
        }
    }
}

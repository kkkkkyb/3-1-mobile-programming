package com.example.mobileprogramming2.lend_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mobileprogramming2.R
import kotlinx.android.synthetic.main.activity_lend_list.*
import kotlinx.android.synthetic.main.start_page.view.*

class LendListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lend_list)

        var adapter = LendListAdapter(this)
        listView.adapter = adapter

        supportActionBar?.title = "대여내역"

        listView.setOnItemClickListener { parent, view, position, id ->
            list()
        }
    }

    fun list() {
        val cInflater = LayoutInflater.from(this).inflate(R.layout.lend_list_page, null)

        val cBuilder = AlertDialog.Builder(this).setView(cInflater)

        val cAlertDialog = cBuilder.show()
        cInflater.button3.setOnClickListener{
            cAlertDialog.dismiss()

            Toast.makeText(applicationContext, "반납하였습니다", Toast.LENGTH_LONG).show()

        }
        cInflater.button2.setOnClickListener{
            cAlertDialog.dismiss()

            Toast.makeText(applicationContext, "취소를 선택했습니다", Toast.LENGTH_LONG).show()
        }
    }
}

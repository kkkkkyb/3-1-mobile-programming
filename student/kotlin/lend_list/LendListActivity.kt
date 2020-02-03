package com.example.mobileprogramming.lend_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileprogramming.R
import kotlinx.android.synthetic.main.activity_lend_list.*

class LendListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lend_list)

        var adapter = LendListAdapter(this)
        listView.adapter = adapter

        supportActionBar?.title = "대여내역"
    }
}

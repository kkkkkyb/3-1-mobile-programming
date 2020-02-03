package com.example.mobileprogramming.delay_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileprogramming.R
import kotlinx.android.synthetic.main.activity_lend_list.*

class DelayListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delay_list)

        var adapter = DelayListAdapter(this)
        listView.adapter = adapter

        supportActionBar?.title = "연체일 수"
    }
}
package com.example.admin.content

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.R
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        var adapter = ContentAdapter(this)
        listView.adapter = adapter

        supportActionBar?.title = "관리자"
    }
}

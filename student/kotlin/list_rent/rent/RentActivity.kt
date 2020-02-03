package com.example.mobileprogramming.list_rent.rent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileprogramming.R
import kotlinx.android.synthetic.main.activity_rent.*

class RentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent)

        supportActionBar?.title = "해당학과"

        button_rent_rent.setOnClickListener {
            finish()
        }
    }
}

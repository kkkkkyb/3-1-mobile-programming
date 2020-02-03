package com.example.mobileprogramming.list_rent.reservation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileprogramming.R
import kotlinx.android.synthetic.main.activity_rent.*

class ReservationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        supportActionBar?.title = "해당학과"

        button_rent_rent.setOnClickListener {
            finish()
        }
    }
}

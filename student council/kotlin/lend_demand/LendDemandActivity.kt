package com.example.mobileprogramming2.lend_demand

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mobileprogramming2.R
import kotlinx.android.synthetic.main.activity_lend_demand.*
import kotlinx.android.synthetic.main.start_page.view.*

class LendDemandActivity : AppCompatActivity() {

    var adapter = LendDemandAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lend_demand)

        listView1.adapter = adapter

        supportActionBar?.title = "대여요청"

        listView1.setOnItemClickListener { parent, view, position, id ->
            val cInflater = LayoutInflater.from(this).inflate(R.layout.lend_demand_page, null)

            val cBuilder = AlertDialog.Builder(this).setView(cInflater)

            val cAlertDialog = cBuilder.show()
            cInflater.button3.setOnClickListener{
                cAlertDialog.dismiss()

                Toast.makeText(applicationContext, "승낙하였습니다", Toast.LENGTH_LONG).show()

            }
            cInflater.button2.setOnClickListener{
                cAlertDialog.dismiss()

                Toast.makeText(applicationContext, "취소를 선택했습니다", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun demand() {
        val cInflater = LayoutInflater.from(this).inflate(R.layout.lend_demand_page, null)

        val cBuilder = AlertDialog.Builder(this).setView(cInflater)

        val cAlertDialog = cBuilder.show()
        cInflater.button3.setOnClickListener{
            cAlertDialog.dismiss()

            Toast.makeText(applicationContext, "승낙하였습니다", Toast.LENGTH_LONG).show()

        }
        cInflater.button2.setOnClickListener{
            cAlertDialog.dismiss()

            Toast.makeText(applicationContext, "취소를 선택했습니다", Toast.LENGTH_LONG).show()
        }
    }
}

package com.example.mobileprogramming.list_rent

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.mobileprogramming.R
import com.example.mobileprogramming.delay_list.DelayListActivity
import com.example.mobileprogramming.lend_list.LendListActivity
import com.example.mobileprogramming.list_rent.rent.RentActivity
import com.example.mobileprogramming.list_rent.reservation.ReservationActivity
import com.example.mobileprogramming.reservation_list.ReservationListActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // 문자열
    val data = arrayOf("우산", "공학용계산기", "실험복")
    var fbAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "해당학과"

        var adapter = ListviewAdapterRent(this)
        listView1.adapter = adapter

        listView1.setOnItemClickListener { parent, view, position, id ->
            var curItem = adapter.getItem(position)
            Toast.makeText(this, "${curItem.itemName} 선택", Toast.LENGTH_LONG).show()

            if(curItem.itemAmount == "0개 남음") {
                var intent = Intent(this, ReservationActivity::class.java)
                startActivity(intent)
            } else {
                var intent = Intent(this, RentActivity::class.java)
                startActivity(intent)
            }
        }

        button_logout.setOnClickListener{ view ->
            showMessage(view, "Logging Out...")
            fbAuth.signOut()
        }

        fbAuth.addAuthStateListener {
            if(fbAuth.currentUser == null){
                this.finish()
            }
        }

        //네비게이션바의 토글버튼 생성(드로어 열고 닫기)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.lend_list -> {
                Toast.makeText(this, "대여내역 선택 ", Toast.LENGTH_SHORT).show()

                var intent = Intent(this, LendListActivity::class.java)
                startActivity(intent)
            }
            R.id.reservation_list -> {
                Toast.makeText(this, "예약내역 선택 ", Toast.LENGTH_SHORT).show()

                var intent2 = Intent(this, ReservationListActivity::class.java)
                startActivity(intent2)
            }
            R.id.delay_list -> {
                Toast.makeText(this, "연체일 수 선택 ", Toast.LENGTH_SHORT).show()

                var intent3 = Intent(this, DelayListActivity::class.java)
                startActivity(intent3)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun showMessage(view: View, message: String){
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show()
    }
}


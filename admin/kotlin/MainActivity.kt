package com.example.admin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.admin.content.ContentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var collegeName = arrayOf("가천리버럴아츠칼리지", "경영대학", "사회과학대학", "인문대학",
        "법과대학", "공과대학", "바이오나노대학", "IT대학", "한의과대학", "예술대학")
    var departName = arrayOf("자유전공", "경영학과", "응용통계학과", "한국어문학과",
        "법학과", "도시계획학과", "식품생물공학과", "컴퓨터공학과", "한의예과", "회화조소전공")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "관리자"

        button.setOnClickListener {
            var intent = Intent(this, ContentActivity::class.java)
            startActivity(intent)
        }

        // 스피너에 연결할 어댑터 설정
        var adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, collegeName)
        var adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, departName)
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // spinner, spinner2에 어댑터 설정
        spinner.adapter = adapter1
        spinner2.adapter = adapter2

        // 스피너에 리스터 등록
        var listener = SpinnerListener()
        spinner.onItemSelectedListener = listener

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    inner class SpinnerListener: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}

package com.example.mobileprogramming2.add

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobileprogramming2.R
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private val GALLERY_CODE = 1112

    var permissionList = arrayOf(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.CAMERA
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        supportActionBar?.title = "해당학과"

        img_btn.setOnClickListener {
            checkPermission()
        }

        add_item_btn.setOnClickListener {
            finish()
        }
    }

    fun checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) { return }

        for (pms: String in permissionList) {
            var permission_chk = checkSelfPermission(pms)

            if (permission_chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permissionList, 0)
                break
            } else {
                selectGallery()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (idx in grantResults.indices) {
            if (grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "허가됨", Toast.LENGTH_LONG).show()
                // 갤러리 열기
                selectGallery()
            } else {
                Toast.makeText(this, "허가안됨", Toast.LENGTH_LONG).show()
                // 취소
            }
        }
    }

    private fun selectGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        intent.type = "image/*"
        startActivityForResult(intent, GALLERY_CODE)
    }
}

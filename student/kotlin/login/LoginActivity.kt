package com.example.mobileprogramming.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import com.example.mobileprogramming.list_rent.MainActivity
import com.example.mobileprogramming.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var fbAuth = FirebaseAuth.getInstance()

    var lockButton = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        fbAuth.currentUser?.let {
            Intent(this, MainActivity::class.java).run {
                startActivity(this)
                finish()
            }
        }

        btn_register.setOnClickListener {
            if (!lockButton) {
                /* 이메일주소와 비밀번호 입력여부 검사*/
                isValidateInputs()?.let { pair ->
                    lockButton = true
                    progressBar.visibility = View.VISIBLE
                    /* 이메일주소와 비밀번호를 가져와 유효성을 검사한 후 신규 사용자를 생성(회원가입) */
                    fbAuth.createUserWithEmailAndPassword(pair.first, pair.second)
                        .addOnCompleteListener { task ->
                            /* 성공한 경우*/
                            task.addOnSuccessListener {
                                lockButton = false
                                progressBar.visibility = View.GONE
                                Toast.makeText(this, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                            }

                            /* 실패한 경우*/
                            task.addOnFailureListener {
                                lockButton = false
                                progressBar.visibility = View.GONE
                                Toast.makeText(this, "에러발생: + ${it.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                }

            } else {
                Toast.makeText(this, "이전요청을 처리중입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        button_login.setOnClickListener {
            isValidateInputs()?.let { pair ->
                fbAuth.signInWithEmailAndPassword(pair.first, pair.second).addOnCompleteListener { task ->
                    /* 성공한 경우*/
                    task.addOnSuccessListener {
                        lockButton = false
                        progressBar.visibility = View.GONE
                        /*로그인 성공시 바로 MainActivity로 이동합니다.*/
                        Intent(this, MainActivity::class.java).run {
                            startActivity(this)
                            finish()
                        }
                    }

                    /* 실패한 경우*/
                    task.addOnFailureListener {
                        lockButton = false
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    fun isValidateInputs(): Pair<String, String>? {
        val userEmail = text_std_num.text.toString()
        val userPassword = text_name.text.toString()
        if (userEmail.isBlank() || userPassword.isBlank()) {
            Toast.makeText(this, "이메일과 비밀번호흘 입력해주세요", Toast.LENGTH_LONG).show()
            return null
        } else {
            return Pair(userEmail, userPassword)
        }
    }
}

package com.example.chronometr

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var timer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.max = 60
        var count = 0

        timer = object : CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")

            override fun onTick(millisUntilFinished: Long) {

                tvSecond.text =
                    " (${(millisUntilFinished / 1000).toString().replace(".", "")})s"
                count++

                progressBar.progress = count
            }

            override fun onFinish() {
                tvSecond.visibility = View.GONE
                btn_start.isEnabled = true
                progressBar.progress = 0
            }

        }


        btn_start.setOnClickListener {

            progressBar.progress = 0

            timer.start()
            btn_start.isEnabled = false


        }


    }


}
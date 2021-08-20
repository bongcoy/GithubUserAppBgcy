package com.example.githubuserappbgcy.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.githubuserappbgcy.R
import com.example.githubuserappbgcy.list.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private var mDelayHandler: Handler? = null
    private val durasi: Long = 2000 // 2 detik

    internal val mRunnable: Runnable = Runnable {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mDelayHandler = Handler(Looper.getMainLooper())
        mDelayHandler!!.postDelayed(mRunnable, durasi)
    }
}
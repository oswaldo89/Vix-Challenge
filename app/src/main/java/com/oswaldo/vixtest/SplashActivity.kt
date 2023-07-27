package com.oswaldo.vixtest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oswaldo.vixtest.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        setupVideoSplash()
    }

    private fun setupVideoSplash() {
        val videoPath = "android.resource://" + packageName + "/" + R.raw.intro
        binding.apply {
            video.setVideoPath(videoPath)
            video.start()
            setupVideoListener()
        }
    }

    private fun setupVideoListener() {
        binding.video.setOnCompletionListener {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
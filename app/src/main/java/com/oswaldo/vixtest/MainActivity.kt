package com.oswaldo.vixtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oswaldo.vixtest.R
import com.oswaldo.vixtest.databinding.ActivityMainBinding
import com.oswaldo.vixtest.databinding.ActivitySplashBinding
import com.oswaldo.vixtest.home.presentation.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, HomeFragment())
                .commit()
        }
    }
}
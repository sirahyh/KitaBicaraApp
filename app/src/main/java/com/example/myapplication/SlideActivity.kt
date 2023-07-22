package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class SlideActivity : AppCompatActivity() {

    companion object {
        lateinit var viewPager: ViewPager
    }

    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        viewPager = findViewById(R.id.viewpager)
        adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        if (isOpenAlready()) {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            val editor = getSharedPreferences("slide", Context.MODE_PRIVATE).edit()
            editor.putBoolean("slide", true)
            editor.apply()
        }
    }

    private fun isOpenAlready(): Boolean {
        val sharedPreferences = getSharedPreferences("slide", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("slide", false)
    }
}

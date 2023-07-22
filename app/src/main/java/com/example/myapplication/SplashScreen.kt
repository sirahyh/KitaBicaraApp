package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    companion object {
        private const val PREFS_NAME = "MyPrefsFile"
        private const val PREF_FIRST_RUN = "isFirstRun"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val settings = getSharedPreferences(PREFS_NAME, 0)
        val isFirstRun = settings.getBoolean(PREF_FIRST_RUN, true)

        if (isFirstRun) {
            // Jika aplikasi belum pernah dijalankan sebelumnya, arahkan ke layar onboarding
            val intent = Intent(this, SlideActivity::class.java)
            startActivity(intent)

            // Set status "telah dijalankan" pada SharedPreferences
            val editor: SharedPreferences.Editor = settings.edit()
            editor.putBoolean(PREF_FIRST_RUN, false)
            editor.apply()
        } else {
            // Jika aplikasi telah dijalankan sebelumnya, arahkan ke layar beranda (misalnya MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        finish()
//        Handler().postDelayed({
//            startActivity(Intent(this, SlideActivity::class.java))
//            finish()
//        }, SPLASH_TIME_OUT)
    }
}
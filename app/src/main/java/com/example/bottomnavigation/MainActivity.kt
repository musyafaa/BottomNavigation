package com.example.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.fragment.HomeFragment
import com.example.bottomnavigation.fragment.NotificationFragment
import com.example.bottomnavigation.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homefragment = HomeFragment()
        val notiffragment = NotificationFragment()
        val settingfragmet = SettingFragment()

        makeCurrentFragment (homefragment)

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomnav)

        bottomnav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(homefragment)
                R.id.menu_notif -> makeCurrentFragment(notiffragment)
                R.id.menu_setting -> makeCurrentFragment(settingfragmet)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framenav, fragment)
            commit()
        }

    }
}
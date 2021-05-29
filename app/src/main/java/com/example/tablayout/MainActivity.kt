package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var tab: TabLayout
    lateinit var viewPager2: ViewPager2
    lateinit var tabLayoutAdapter: TabLayoutAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab = findViewById(R.id.tab)
        viewPager2 = findViewById(R.id.viewpager2)
        tabLayoutAdapter = TabLayoutAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = tabLayoutAdapter
        TabLayoutMediator(tab, viewPager2){tab, position ->
            when(position){
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.home)
                }
                1 -> {
                    tab.text = "Favorite"
                    tab.setIcon(R.drawable.favorite)
                }
                else -> {
                    tab.text = "Settings"
                    tab.setIcon(R.drawable.settings)
                }
            }
        }.attach()
    }
}
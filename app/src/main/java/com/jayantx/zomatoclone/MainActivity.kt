package com.jayantx.zomatoclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jayantx.zomatoclone.fragments.DeliveryFragment
import com.jayantx.zomatoclone.fragments.FavouriteFragment
import com.jayantx.zomatoclone.fragments.HistoryFragment
import com.jayantx.zomatoclone.fragments.VideosFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ReplaceFragment(DeliveryFragment())

        bottom_navigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.nav_delivery -> {
                    ReplaceFragment(DeliveryFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_favourite -> {
                    ReplaceFragment(FavouriteFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_history -> {
                    ReplaceFragment(HistoryFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_videos -> {
                    ReplaceFragment(VideosFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun ReplaceFragment(fragmentName: Fragment){
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.main_frame_layout,fragmentName)
        fragmentManager.commit()
    }
}

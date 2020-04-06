package com.jayantx.zomatoclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.jayantx.zomatoclone.fragments.DeliveryFragment
import com.jayantx.zomatoclone.fragments.FavouriteFragment
import com.jayantx.zomatoclone.fragments.HistoryFragment
import com.jayantx.zomatoclone.fragments.VideosFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawer_navigation_view = findViewById<NavigationView>(R.id.drawer_navigation_view)
        setSupportActionBar(toolbar)
        val toogle = ActionBarDrawerToggle(this,drawer_layout,0,0)
        drawer_layout.addDrawerListener(toogle)
        toogle.syncState()

        drawer_navigation_view.setNavigationItemSelectedListener(this)
        drawer_navigation_view.bringToFront()


        three.setOnClickListener{
            drawer_layout.openDrawer(GravityCompat.END)
        }





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


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.your_orders_nav -> {
                Toast.makeText(this, "your_orders_nav clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.favourite_orders_nav -> {
                Toast.makeText(this, "favourite_orders_nav clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.address_book_nav -> {
                Toast.makeText(this, "address_book_nav clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.online_ordering_nav -> {
                Toast.makeText(this, "online_ordering_nav clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.send_feed_back_nav -> {
                Toast.makeText(this, "send_feed_back_nav  clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.developer_nav -> {
                Toast.makeText(this, " developer_nav clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.log_out_nav -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.END)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.END)){
            drawer_layout.closeDrawer(GravityCompat.END)
        }
        else{
            super.onBackPressed()
        }
    }
}

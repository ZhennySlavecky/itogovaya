package com.zhenny.sensor

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.hardware.Sensor
import android.hardware.SensorManager

private const val LAST_SELECTED_ITEM = "item"
private val SENSOR_FRAGMENT = SensorFragment().javaClass.name
private val ABOUT_FRAGMENT = AboutFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_menu)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.fragment_1 -> {
                    fragment = if (savedInstanceState != null)
                        supportFragmentManager.getFragment(savedInstanceState, SENSOR_FRAGMENT)
                    else SensorFragment()

                }
                R.id.fragment_2 -> {
                    fragment = if (savedInstanceState != null)
                        supportFragmentManager.getFragment(savedInstanceState, ABOUT_FRAGMENT)
                    else AboutFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationView.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.fragment_1
          //  R.id.fragment_1
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
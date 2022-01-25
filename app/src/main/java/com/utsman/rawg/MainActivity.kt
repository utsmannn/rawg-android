package com.utsman.rawg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.utsman.maingamesimpl.presenter.fragment.MainGameFragment
import com.utsman.maingamesimpl.presenter.fragment.SearchGameFragment

class MainActivity : AppCompatActivity() {

    private val pagerAdapter: GameViewPagerAdapter by lazy {
        GameViewPagerAdapter(supportFragmentManager)
    }

    private val bottomNavigation: BottomNavigationView by lazy {
        findViewById(R.id.main_bottom_nav)
    }

    private val viewPager: ViewPager by lazy {
        findViewById(R.id.main_view_pager)
    }

    private val toolbar: Toolbar by lazy {
        findViewById(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerAdapter.addFragment(MainGameFragment(), SearchGameFragment())
        viewPager.adapter = pagerAdapter
        toolbar.title = "Home"

        bottomNavigation.setOnItemSelectedListener {
            return@setOnItemSelectedListener when (it.itemId) {
                R.id.action_home -> {
                    viewPager.setCurrentItem(0, true)
                    toolbar.title = "Home"
                    true
                }
                R.id.action_search -> {
                    viewPager.setCurrentItem(1, true)
                    toolbar.title = "Search"
                    true
                }
                else -> false
            }
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                bottomNavigation.selectedItemId = when (position) {
                    0 -> R.id.action_home
                    1 -> R.id.action_search
                    else -> 0
                }
            }

        })
    }
}
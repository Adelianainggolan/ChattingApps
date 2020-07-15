package com.adelia.nanggolan.chattingapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.adelia.nanggolan.chattingapps.fragment.ChatFragment
import com.adelia.nanggolan.chattingapps.fragment.SearchFragment
import com.adelia.nanggolan.chattingapps.fragment.SettingFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tool_bar)

        val toolbar: Toolbar = findViewById(R.id.tool_bar)
        setActionBar(toolbar)
        supportActionBar!!.title = ""

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val viewPagerAdapater = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapater.addFragment(ChatFragment(), "chats")
        viewPagerAdapater.addFragment(SearchFragment(), "search")
        viewPagerAdapater.addFragment(SettingFragment(), "setting")

        viewPager.adapter = viewPagerAdapater
        tabLayout.setupWithViewPager(viewPager)

    }

    internal class  ViewPagerAdapter(fragmentManager: FragmentManager):
            FragmentPagerAdapter(fragmentManager){
        private val titles : ArrayList<String>
        private val fragments : ArrayList<Fragment>
        init{
            titles = ArrayList()
            fragments = ArrayList()
        }
        override fun getItem(position: Int): Fragment {
            return fragments [position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

        fun addFragment(fragment: Fragment, title: String){
            fragments.add(fragment)
            titles.add(title)
        }

    }
}

package com.viren.shoppingapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.viren.shoppingapp.ui.ProductListFragment
import com.viren.shoppingapp.ui.UserDetailFragment

class TabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val NUM_TABS = 2

   /* override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }

    override fun getItem(position: Int): Fragment {

    }*/

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                ProductListFragment()
            }
            1 -> {
                UserDetailFragment()
            }

            else -> ProductListFragment()
        }
    }

}

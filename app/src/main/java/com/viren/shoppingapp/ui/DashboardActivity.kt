package com.viren.shoppingapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.viren.shoppingapp.R
import com.viren.shoppingapp.adapter.ProductListAdapter
import com.viren.shoppingapp.adapter.TabAdapter
import com.viren.shoppingapp.databinding.ActivityDashboardBinding
import com.viren.shoppingapp.viewmodel.ProductListViewModel


class DashboardActivity : AppCompatActivity() {

    private var exit: Boolean = false
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var productAdapter: ProductListAdapter
    lateinit var productViewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)

        binding.viewPager.adapter = TabAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Product"
                1 -> tab.text = "Profile"
                else -> tab.text = "undefined"
            }
        }.attach()

    }


}
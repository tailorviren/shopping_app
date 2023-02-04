package com.viren.shoppingapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.viren.shoppingapp.R
import com.viren.shoppingapp.adapter.ProductListAdapter
import com.viren.shoppingapp.databinding.FragmentProductListBinding
import com.viren.shoppingapp.viewmodel.ProductListViewModel

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private lateinit var productAdapter: ProductListAdapter
    lateinit var productViewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        productViewModel = ViewModelProvider(this)[ProductListViewModel::class.java]

        productViewModel.getProductList()
        productAdapter = ProductListAdapter()

        productViewModel.productList.observe(this, Observer {
            binding.rvProductList.adapter = productAdapter
            productAdapter.addData(it)
            binding.shimmerContainer.visibility = View.GONE
            binding.shimmerContainer.stopShimmer()
        })

        productAdapter.onItemClick = {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("data", it)
            startActivity(intent)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        binding.shimmerContainer.startShimmer()
    }

    override fun onPause() {
        binding.shimmerContainer.stopShimmer()
        super.onPause()
    }

}
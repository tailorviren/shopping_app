package com.viren.shoppingapp.ui

import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.viren.shoppingapp.R
import com.viren.shoppingapp.databinding.ActivityDescriptionBinding
import com.viren.shoppingapp.model.Product


class DescriptionActivity : AppCompatActivity() {

    lateinit var binding : ActivityDescriptionBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_description)

        val product : Product? = intent.getParcelableExtra("data")

        binding.txtDescription.text = product?.productDesc
        binding.txtProductName.text = product?.name
        binding.txtSellPrice.text = "₹".plus(product?.offerPrice)
        binding.txtCostPrice.text = "₹".plus(product?.price)

        Glide.with(this).load(product?.productUrl).into(binding.imgImage)

        binding.txtCostPrice.paintFlags = binding.txtCostPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }
}
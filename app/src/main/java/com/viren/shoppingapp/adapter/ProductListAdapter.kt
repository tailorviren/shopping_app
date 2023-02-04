package com.viren.shoppingapp.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.viren.shoppingapp.R
import com.viren.shoppingapp.databinding.LayRewardBinding
import com.viren.shoppingapp.databinding.ProductListBinding
import com.viren.shoppingapp.model.Product


class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var viewPos: Int = 0

    //private var view: View? = null
    private var alData: ArrayList<Product> = ArrayList()
    private lateinit var binding: ProductListBinding
    private lateinit var binding1: LayRewardBinding
    var onItemClick: ((Product) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(productData: Product) {
            viewPos = adapterPosition

            val image: ImageView = itemView.findViewById(R.id.imgImage)
            val txtProductName: AppCompatTextView = itemView.findViewById(R.id.txtProductName)
            val txtDescription: AppCompatTextView = itemView.findViewById(R.id.txtDescription)
            val txtSellPrice: AppCompatTextView = itemView.findViewById(R.id.txtSellPrice)
            val txtCostPrice: AppCompatTextView = itemView.findViewById(R.id.txtCostPrice)

            Glide.with(itemView.context).load(productData.productUrl).into(image)
            txtProductName.text = productData.name
            txtDescription.text = productData.productDesc
            txtSellPrice.text = productData.offerPrice
            txtCostPrice.text = productData.price

            txtCostPrice.paintFlags = txtCostPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (viewPos) {
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.lay_reward, parent, false)

                ViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.product_list, parent, false)

                ViewHolder(view)
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = alData[position]
        holder.bindView(item)
        holder.itemView.setOnClickListener {
            if (position == 2) {
                Toast.makeText(
                    holder.itemView.context,
                    holder.itemView.context.getString(R.string.thank_you_reward_program),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                onItemClick?.invoke(alData[position])
            }
        }
    }

    fun addData(alData: ArrayList<Product>) {
        this.alData = alData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = alData.size

}
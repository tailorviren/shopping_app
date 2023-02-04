package com.viren.shoppingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viren.shoppingapp.Cloud.DataManager
import com.viren.shoppingapp.model.Data
import com.viren.shoppingapp.model.GetProductItems
import com.viren.shoppingapp.model.Product
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    var productList = MutableLiveData<ArrayList<Product>>()

    fun getProductList(){
        viewModelScope.launch {
            val response = DataManager.getInstance().getRemote().getProductList()
            if(response.data.products.size > 0){
                productList.value = response.data.products
            }
        }
    }

}
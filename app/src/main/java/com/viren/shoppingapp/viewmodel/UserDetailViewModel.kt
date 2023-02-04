package com.viren.shoppingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viren.shoppingapp.Cloud.DataManager
import com.viren.shoppingapp.model.UserProfile
import kotlinx.coroutines.launch

class UserDetailViewModel : ViewModel() {

    var userDetail = MutableLiveData<UserProfile>()


    fun getUserDetail() {
        viewModelScope.launch {
            val response = DataManager.getInstance().getRemote().userProfile()
            if (response != null) {
                userDetail.value = response
            }
        }
    }
}
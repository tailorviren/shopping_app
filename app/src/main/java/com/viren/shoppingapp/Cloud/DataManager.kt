package com.viren.shoppingapp.Cloud

class DataManager : IDataManager {

    companion object {
        private var INSTANCE: IDataManager? = null

        fun getInstance(): IDataManager {
            if (INSTANCE == null)
                INSTANCE = DataManager()
            return INSTANCE!!
        }
    }

    override fun getRemote(): APIService {
        return RetrofitBuilder.RetrofitBuilder.getRetrofit().create(APIService::class.java)
    }


}
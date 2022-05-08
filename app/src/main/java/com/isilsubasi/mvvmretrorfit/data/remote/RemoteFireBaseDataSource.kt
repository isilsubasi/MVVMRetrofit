package com.isilsubasi.mvvmretrorfit.data.remote

import com.isilsubasi.mvvmretrorfit.Resource
import com.isilsubasi.mvvmretrorfit.data.UserDataSource
import com.isilsubasi.mvvmretrorfit.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteFireBaseDataSource : UserDataSource {
    override  fun getAllUsers(): Flow<Resource<UserResponse>> = flow {
        try {
            emit(Resource.Loading())

            //TODO - Firebase işlemleri için sadece burası değişecek
            val response = UserService.build().getAllUsers()

            if (response.isSuccessful) {

                response.body()?.let {
                    emit(Resource.Success(it))
                }
            }

        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }
}
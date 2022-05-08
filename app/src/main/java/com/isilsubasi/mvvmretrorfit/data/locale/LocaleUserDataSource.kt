package com.isilsubasi.mvvmretrorfit.data.locale

import com.isilsubasi.mvvmretrorfit.Resource
import com.isilsubasi.mvvmretrorfit.data.UserDataSource
import com.isilsubasi.mvvmretrorfit.data.model.UserResponse
import com.isilsubasi.mvvmretrorfit.data.remote.UserService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocaleUserDataSource : UserDataSource {
    override  fun getAllUsers(): Flow<Resource<UserResponse>> = flow {
        try {
            emit(Resource.Loading())

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
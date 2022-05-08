package com.isilsubasi.mvvmretrorfit.data

import com.isilsubasi.mvvmretrorfit.Resource
import com.isilsubasi.mvvmretrorfit.data.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    fun getAllUsers(): Flow<Resource<UserResponse>>

}
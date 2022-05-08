package com.isilsubasi.mvvmretrorfit.data.repository

import com.isilsubasi.mvvmretrorfit.Resource
import com.isilsubasi.mvvmretrorfit.data.UserDataSource
import com.isilsubasi.mvvmretrorfit.data.model.UserResponse
import com.isilsubasi.mvvmretrorfit.data.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow

class UserRepository {

    private var userDataSource: UserDataSource?=null

    init {
        userDataSource=RemoteUserDataSource()
    }

    fun getAllUsers(): Flow<Resource<UserResponse>>
    {
        return userDataSource!!.getAllUsers()
    }

}

package com.isilsubasi.mvvmretrorfit


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getAllUsers(): Response<UsersResponse>

    companion object  {

        fun build(): UserService {

            //Loglarda
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHtppClient =  OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            //retrofiti kurarken okHttpi kurup set ettim.
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHtppClient)
                .build() // Bu servisle istediğim isteği atabileceğim

            return retrofit.create(UserService::class.java)
        }
    }



}
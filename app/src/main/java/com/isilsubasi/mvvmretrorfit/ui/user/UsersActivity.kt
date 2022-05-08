package com.isilsubasi.mvvmretrorfit.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.isilsubasi.mvvmretrorfit.R
import com.isilsubasi.mvvmretrorfit.databinding.ActivityMainBinding

class UsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var userViewModel: UserViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
    }
    fun initViewModel()
    {
        userViewModel= UserViewModel()
        userViewModel?.apply {

            allUsersLiveData?.observe(this@UsersActivity, Observer {

                it.run {



                }
            })

            error?.observe(this@UsersActivity, Observer {

                it.run {
                    Toast.makeText(applicationContext,this.localizedMessage, Toast.LENGTH_LONG).show()
                }
            })

            loading?.observe(this@UsersActivity, Observer {

                //Handle loading
            })
        }
    }




}
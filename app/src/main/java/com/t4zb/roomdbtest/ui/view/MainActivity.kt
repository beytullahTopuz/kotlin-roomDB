package com.t4zb.roomdbtest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.t4zb.roomdbtest.databinding.ActivityMainBinding
import com.t4zb.roomdbtest.ui.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding : ActivityMainBinding
    private val mViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mbinding.root
        setContentView(view)



       mbinding.addPW.setOnClickListener {
           mViewModel.insertPassword()
       }
        mbinding.showPW.setOnClickListener {
            mViewModel.getAllPassword()
        }
        mbinding.showOnePW.setOnClickListener {
            mViewModel.getPassword(1)
        }
    }
}
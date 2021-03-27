package com.ersincoskun.taskapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ersincoskun.taskapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    private lateinit var fragmentFactory: MovieFragmentFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_main)
    }
}
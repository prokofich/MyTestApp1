package com.sss.mytestapp1.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sss.mytestapp1.R
import com.sss.mytestapp1.databinding.ActivityMainBinding
import com.sss.mytestapp1.model.constant.MAIN

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        MAIN = this
        navController = Navigation.findNavController(this, R.id.id_nav_host)

    }
}
package com.tguillaume.samplecharacter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tguillaume.samplecharacter.databinding.ActivityMainBinding

/**
 * @Project : Sample Character
 *
 * MainActivity.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding
        get() = _binding!!
    private var _binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
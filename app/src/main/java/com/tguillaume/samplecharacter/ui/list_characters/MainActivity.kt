package com.tguillaume.samplecharacter.ui.list_characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tguillaume.samplecharacter.R
import com.tguillaume.samplecharacter.data.Character
import com.tguillaume.samplecharacter.data.MyDatabase
import com.tguillaume.samplecharacter.databinding.ActivityMainBinding
import com.tguillaume.samplecharacter.ui.list_characters.adapters.CharactersAdapter

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

    private var adapter: CharactersAdapter? = null
    private val database = MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initRecyclerView(){
        adapter = CharactersAdapter(context = this, dataSet = listOf())
        binding.charactersRecyclerview.adapter = adapter
        binding.charactersRecyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData(){
        val listCharaters: List<Character> = database.getAllCharacters()
        adapter?.dataSet = listCharaters
        adapter?.notifyDataSetChanged()
    }
}
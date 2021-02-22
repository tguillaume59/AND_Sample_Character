package com.tguillaume.samplecharacter.ui.add_character

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tguillaume.samplecharacter.R
import com.tguillaume.samplecharacter.data.Character
import com.tguillaume.samplecharacter.data.MyDatabase
import com.tguillaume.samplecharacter.data.SexEnum
import com.tguillaume.samplecharacter.databinding.ActivityAddCharacterBinding

/**
 * @Project : Sample Character
 *
 * AddCharacterActivity.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
class AddCharacterActivity : AppCompatActivity(R.layout.activity_add_character) {

    private val binding: ActivityAddCharacterBinding
        get() = _binding!!
    private var _binding: ActivityAddCharacterBinding? = null

    private val database = MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAddCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initOnClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initOnClick() {
        binding.validateButton.setOnClickListener { onClickValidate() }
    }

    private fun onClickValidate() {
        val lastname: String = binding.lastnameEdittext.text.toString()
        val firstname: String = binding.firstnameEdittext.text.toString()
        val age: String = binding.ageEdittext.text.toString()
        val job = binding.jobEdittext.text.toString()

        if (lastname.isNotBlank() && firstname.isNotBlank() && age.isNotBlank()) {
            saveData(
                lastname,
                firstname,
                age.toInt(),
                SexEnum.BOY, //todo
                job
            )
            finish()
        } else {
            printError(getString(R.string.error_missing_data))
        }

    }

    private fun printError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun saveData(lastname: String, firstname: String, age: Int, sex: SexEnum, job: String) {
        val newCharater = Character(firstname, lastname, age, sex, job)
        database.save(newCharater)
    }
}
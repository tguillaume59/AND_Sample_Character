package com.tguillaume.samplecharacter.ui.profil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tguillaume.samplecharacter.R
import com.tguillaume.samplecharacter.data.Character
import com.tguillaume.samplecharacter.data.MyDatabase
import com.tguillaume.samplecharacter.databinding.ActivityProfileBinding
import com.tguillaume.samplecharacter.ui.common.BundleKeys
import com.tguillaume.samplecharacter.ui.common.ProfilePictureManager

/**
 * @Project : Sample Character
 *
 * ProfileActivity.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
class ProfileActivity : AppCompatActivity(R.layout.activity_profile) {

    private val binding: ActivityProfileBinding
        get() = _binding!!
    private var _binding: ActivityProfileBinding? = null

    private val database = MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun loadData() {
        val characterId: Int? = intent.extras?.getInt(BundleKeys.CHARACTER_ID)

        characterId?.let { id ->
            val character: Character? = database.getCharacterById(id = id)

            character?.let { initViewWithData(character = it) }
        }
    }

    private fun initViewWithData(character: Character) {
        binding.profileFirstnameTextview.text =
            getString(R.string.profile_firstname, character.firstName)

        binding.profileLastnameTextview.text =
            getString(R.string.profile_lastname, character.lastName)

        binding.profileAgeTextview.text = getString(R.string.profile_age, character.age)

        val jobText: String = if (character.job.isNotBlank()) character.job
        else getString(R.string.no_data)
        binding.profileJobTextview.text = getString(R.string.profile_job, jobText)

        val drawable = ProfilePictureManager.getDrawableBySex(context = this, sex = character.sex)
        binding.profileImageView.setImageDrawable(drawable)
    }
}
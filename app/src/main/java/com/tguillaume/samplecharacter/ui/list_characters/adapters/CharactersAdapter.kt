package com.tguillaume.samplecharacter.ui.list_characters.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tguillaume.samplecharacter.R
import com.tguillaume.samplecharacter.data.Character
import com.tguillaume.samplecharacter.ui.common.ProfilePictureManager
import com.tguillaume.samplecharacter.ui.list_characters.viewholders.CharacterViewHolder

/**
 * @Project : Sample Character
 *
 * CharactersAdapter.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
class CharactersAdapter(
    val context: Context,
    var dataSet: List<Character>,
    val onCharacterItemClick: ((idCharacter: Int) -> Unit)
) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_character, viewGroup, false)

        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character: Character = dataSet[position]

        holder.firstNameTextview.text = character.firstName
        holder.lastNameTextView.text = character.lastName

        val drawable =
            ProfilePictureManager.getDrawableBySex(context = context, sex = character.sex)
        holder.pictureImageView.setImageDrawable(drawable)

        holder.itemView.setOnClickListener {
            onCharacterItemClick(character.id)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
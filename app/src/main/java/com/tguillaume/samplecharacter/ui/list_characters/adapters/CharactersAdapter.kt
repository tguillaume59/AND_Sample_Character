package com.tguillaume.samplecharacter.ui.list_characters.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tguillaume.samplecharacter.R
import com.tguillaume.samplecharacter.data.Character
import com.tguillaume.samplecharacter.data.SexEnum
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
    var dataSet: List<Character>
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

        val drawable = getDrawableBySex(sex = character.sex)
        holder.pictureImageView.setImageDrawable(drawable)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    private fun getDrawableBySex(sex: SexEnum): Drawable? {
        val idDrawable = when (sex) {
            SexEnum.BOY -> R.drawable.ic_boy
            SexEnum.GIRL -> R.drawable.ic_girl
            SexEnum.EXTRATERRESTRIAL,
            SexEnum.OTHER -> R.drawable.ic_launcher_foreground
        }

        return ContextCompat.getDrawable(context, idDrawable)
    }

}
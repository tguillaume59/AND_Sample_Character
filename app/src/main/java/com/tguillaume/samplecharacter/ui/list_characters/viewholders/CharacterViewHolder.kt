package com.tguillaume.samplecharacter.ui.list_characters.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tguillaume.samplecharacter.R

/**
 * @Project : Sample Character
 *
 * CharacterViewHolder.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val pictureImageView:ImageView
    val firstNameTextview: TextView
    val lastNameTextView: TextView


    init {
        pictureImageView = view.findViewById(R.id.character_picture_imageview)
        firstNameTextview = view.findViewById(R.id.character_firstname_textview)
        lastNameTextView = view.findViewById(R.id.character_lastname_textview)
    }
}
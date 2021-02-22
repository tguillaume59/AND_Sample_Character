package com.tguillaume.samplecharacter.ui.common

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.tguillaume.samplecharacter.R
import com.tguillaume.samplecharacter.data.SexEnum

/**
 * @Project : Sample Character
 *
 * ProfilePictureManager.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
object ProfilePictureManager {

    fun getDrawableBySex(context: Context, sex: SexEnum): Drawable? {
        val idDrawable = when (sex) {
            SexEnum.BOY -> R.drawable.ic_boy
            SexEnum.GIRL -> R.drawable.ic_girl
            SexEnum.EXTRATERRESTRIAL,
            SexEnum.OTHER -> R.drawable.ic_launcher_foreground
        }

        return ContextCompat.getDrawable(context, idDrawable)
    }
}
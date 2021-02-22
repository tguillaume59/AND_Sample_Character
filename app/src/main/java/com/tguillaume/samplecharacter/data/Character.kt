package com.tguillaume.samplecharacter.data

/**
 * @Project : Sample Character
 *
 * Character.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
data class Character(
    val firstName: String,
    val lastName: String,
    var age: Int,
    val sex: SexEnum,
    var job: String = ""
)
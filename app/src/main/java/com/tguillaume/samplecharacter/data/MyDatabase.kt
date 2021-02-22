package com.tguillaume.samplecharacter.data

/**
 * @Project : Sample Character
 *
 * MyDatabase.kt
 *
 * Created by TARTARA Guillaume on 22/02/2021
 * Copyright © 2021 tguillaume. All rights reserved.
 */
object MyDatabase {

    private val listCharacter: MutableList<Character>

    init {
        listCharacter = mutableListOf()
        addMockedData()
    }

    private fun addMockedData(){
        save(Character(firstName = "Clarke", lastName = "Griffin", age = 20, sex = SexEnum.GIRL))
        save(Character(firstName = "Bellamy", lastName = "Blake", age = 24, sex = SexEnum.BOY))
        save(Character(firstName = "Raven", lastName = "Reyes", age = 23, sex = SexEnum.GIRL, job = "Technician"))
        save(Character(firstName = "John", lastName = "Murphy", age = 21, sex = SexEnum.BOY))
        save(Character(firstName = "Abigail", lastName = "Griffin", age = 43, sex = SexEnum.GIRL, job = "Doctor"))
        save(Character(firstName = "Marcus", lastName = "Kane", age = 45, sex = SexEnum.BOY, job = "Security Chief"))
        save(Character(firstName = "Monty", lastName = "Green", age = 19, sex = SexEnum.BOY))
        save(Character(firstName = "Thelonius", lastName = "Jaha", age = 52, sex = SexEnum.BOY, job = "Chancellor"))
        save(Character(firstName = "Echo", lastName = "kom Azgeda", age = 23, sex = SexEnum.GIRL))
        save(Character(firstName = "Lincoln", lastName = "kom Trikru", age = 28, sex = SexEnum.BOY))
        save(Character(firstName = "Finn", lastName = "Collins", age = 21, sex = SexEnum.BOY))
        save(Character(firstName = "Roan", lastName = "kom Azgeda", age = 30, sex = SexEnum.BOY))
    }

    fun getAllCharacters(): List<Character>{
        return listCharacter
    }

    fun getCharacterById(id: Int): Character?{
        return listCharacter.filter { it.id == id }.firstOrNull()
    }

    fun save(character: Character){
        //generate id
        val id: Int = generateId()
        character.id = id

        listCharacter.add(character)
    }

    private fun generateId(): Int{
        return (1..Int.MAX_VALUE).random()
    }
}
package com.retrypay.rickandmorti.data.repository

import com.retrypay.rickandmorti.data.network.datasource.PersonDataSource
import com.retrypay.rickandmorti.util.DataAccessStrategy.performGetOperation

class PersonRepository
constructor(
    private val personDataSource: PersonDataSource = PersonDataSource()
){

    fun getAllPersons(page: Int?) = performGetOperation (
        networkCall = { personDataSource.getAllPersons(page) }
     )

    fun getOnePerson(personId: Int) = performGetOperation (
        networkCall = { personDataSource.getOnePerson(personId) }
    )

    fun getSomePersons(personIds: List<Int>) = performGetOperation (
        networkCall = { personDataSource.getSomePersons(personIds) }
    )

    fun getPersons(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ) = performGetOperation (
        networkCall = { personDataSource.getPersons(name, status, species, type, gender) }
    )

}
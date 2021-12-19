package com.retrypay.rickandmorti.data.network.datasource

import com.retrypay.rickandmorti.data.ApiService
import com.retrypay.rickandmorti.data.network.RetrofitModule
import com.retrypay.rickandmorti.util.BaseDataSource

class PersonDataSource
constructor(
    private val apiService: ApiService = RetrofitModule.getInstance().create(ApiService::class.java)
): BaseDataSource() {

    suspend fun getAllPersons(page: Int?) = getResult {
        apiService.getAllPersons(page)
    }

    suspend fun getOnePerson(personId: Int) = getResult {
        apiService.getOnePerson(personId)
    }

    suspend fun getSomePersons(personIds: List<Int>) = getResult {
        apiService.getSomePersons(personIds)
    }

    suspend fun getPersons(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ) = getResult {
        apiService.filterPersons(name, status, species, type, gender)
    }

}
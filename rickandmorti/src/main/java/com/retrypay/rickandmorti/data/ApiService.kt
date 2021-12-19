package com.retrypay.rickandmorti.data

import com.retrypay.rickandmorti.data.network.model.ApiRMResponse
import com.retrypay.rickandmorti.data.network.model.Person
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getAllPersons(
        @Query("page") page: Int?,
    ): Response<ApiRMResponse>

    @GET("character/{personId}")
    suspend fun getOnePerson(
        @Path("personId") personId: Int
    ): Response<Person>

    @GET("character/{personIds}")
    suspend fun getSomePersons(
        @Path("personIds") personIds: List<Int>
    ): Response<List<Person>>

    @GET("character/")
    suspend fun filterPersons(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?,
    ): Response<ApiRMResponse>

}
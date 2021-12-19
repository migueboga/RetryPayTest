package com.retrypay.rickandmorti.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

object DataAccessStrategy {

    fun <A> performGetOperation(networkCall: suspend () -> Resource<A>
    ): LiveData<Resource<A>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val responseStatus = networkCall.invoke()
        emit(responseStatus)
    }

}
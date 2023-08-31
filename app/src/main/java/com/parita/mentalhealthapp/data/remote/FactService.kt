package com.parita.mentalhealthapp.data.remote

import com.parita.mentalhealthapp.data.remote.model.FactModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FactService  @Inject constructor(private val factsApi: FactsApi){
    suspend fun getFacts(): List<FactModel>{
        return withContext(Dispatchers.IO){
            val facts = factsApi.getFacts()
            facts.body()?: emptyList()
        }
    }
}
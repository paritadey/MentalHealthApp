package com.parita.mentalhealthapp.data.remote

import com.parita.mentalhealthapp.data.remote.model.FactModel
import com.parita.mentalhealthapp.util.Constants.Companion.FACTS_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FactsApi {
    @GET(FACTS_ENDPOINT)
    suspend fun getFacts(): Response<List<FactModel>>
}
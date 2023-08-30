package com.parita.mentalhealthapp.repository

import com.parita.mentalhealthapp.domain.item.FactItem
import com.parita.mentalhealthapp.domain.item.toFactItem
import com.parita.mentalhealthapp.data.remote.FactService
import javax.inject.Inject

class FactsRepository @Inject constructor(private val factService: FactService){
    suspend fun getFacts(): List<FactItem>{
        return factService.getFacts().map {
            it.toFactItem()
        }
    }
}
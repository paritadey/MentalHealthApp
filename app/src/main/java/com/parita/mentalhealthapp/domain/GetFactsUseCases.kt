package com.parita.mentalhealthapp.domain

import com.parita.mentalhealthapp.domain.item.FactItem
import com.parita.mentalhealthapp.repository.FactsRepository
import javax.inject.Inject

class GetFactsUseCases @Inject constructor(private val factsRepository: FactsRepository){
    suspend operator fun invoke(): List<FactItem>{
        return factsRepository.getFacts().shuffled()
    }
}
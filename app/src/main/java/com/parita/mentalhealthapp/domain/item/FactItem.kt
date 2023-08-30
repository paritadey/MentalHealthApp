package com.parita.mentalhealthapp.domain.item

import com.parita.mentalhealthapp.data.remote.model.FactModel

data class FactItem (
    val fact: String
)
fun FactModel.toFactItem() = FactItem(fact)
package com.parita.mentalhealthapp.screens.Splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parita.mentalhealthapp.domain.GetFactsUseCases
import com.parita.mentalhealthapp.domain.item.FactItem
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val factsUseCases: GetFactsUseCases):ViewModel(){
    private val _facts = MutableStateFlow(emptyList<FactItem>())
    val facts : StateFlow<List<FactItem>> get() = _facts

    init {
        getFacts()
    }

    private fun getFacts() {
        viewModelScope.launch{
            try{
                val fact = factsUseCases()
                _facts.value = fact
            }catch (_: Exception){}
        }
    }
}
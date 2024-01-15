package com.parita.mentalhealthapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MultiWindowViewModel @Inject constructor():ViewModel(){
    private var _multiWindowMode = MutableLiveData<Boolean>()
    fun setMultiWindowMode(mode:Boolean) {
        this._multiWindowMode.value = mode
    }

    fun getMultiWindowMode():LiveData<Boolean>{
        return _multiWindowMode
    }
}
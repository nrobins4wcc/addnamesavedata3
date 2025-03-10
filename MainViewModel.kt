package com.example.addnamesavedata3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    //to hold names
     private val _names = MutableLiveData<MutableList<String>>()
    val names: LiveData<MutableList<String>> get() = _names

    init {
        _names.value = mutableListOf()
    }


    // add a name to the list
    fun addName(name: String) {
       _names.value?.apply {
           add(name)
       }
        _names.value = names.value

    }
}
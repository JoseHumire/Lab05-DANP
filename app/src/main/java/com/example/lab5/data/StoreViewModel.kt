package com.example.lab5.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoreViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Store>>
    private val repository: StoreRepository

    init {
        val storeDao = MyDatabase.getDatabase(application).storeDao()
        repository = StoreRepository(storeDao)
        readAllData = repository.readAllData
    }

    fun addStore(store: Store){
        viewModelScope.launch(Dispatchers.IO){
            repository.addStore(store)
        }
    }

}
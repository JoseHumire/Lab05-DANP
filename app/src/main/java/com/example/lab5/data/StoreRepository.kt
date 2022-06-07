package com.example.lab5.data

import androidx.lifecycle.LiveData

class StoreRepository(private val storeDao: StoreDao) {

    val readAllData: LiveData<List<Store>> = storeDao.readAllData()

    suspend fun addStore(store: Store){
        storeDao.addStore(store)
    }
}
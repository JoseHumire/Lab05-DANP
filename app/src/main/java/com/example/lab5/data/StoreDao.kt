package com.example.lab5.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStore(store: Store)

    @Query("SELECT * from store_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Store>>
}
package com.example.lab5.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Product>>
    private val repository: ProductRepository

    init {
        val productDao = MyDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        readAllData = repository.readAllData
    }

    fun addProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            repository.addProduct(product)
        }
    }
    fun deleteProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteProduct(product)
        }
    }
    fun deleteAllProducts(product: Product){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllProducts()
        }
    }

}
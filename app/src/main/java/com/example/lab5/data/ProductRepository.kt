package com.example.lab5.data

import androidx.lifecycle.LiveData

class ProductRepository(private val productDao: ProductDao) {

    val readAllData: LiveData<List<Product>> = productDao.readAllData()

    suspend fun addProduct(product: Product) {
        productDao.addProduct(product)
    }
    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }
    suspend fun deleteAllProducts(){
        productDao.deleteAllProducts()
    }
}
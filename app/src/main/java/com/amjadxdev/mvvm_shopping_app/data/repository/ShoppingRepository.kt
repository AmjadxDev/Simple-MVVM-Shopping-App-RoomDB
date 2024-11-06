package com.amjadxdev.mvvm_shopping_app.data.repository

import com.amjadxdev.mvvm_shopping_app.data.database.ShoppingDao
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem

class ShoppingRepository (
    private val shoppingDao: ShoppingDao
){
    suspend fun insertItem(item : ShoppingItem) = shoppingDao.insertItem(item)

    suspend fun updateItem(item: ShoppingItem) = shoppingDao.updateItem(item)

    suspend fun deleteItem(item : ShoppingItem) = shoppingDao.deleteItem(item)

    fun getShoppingItems() = shoppingDao.getAllShoppingItems()
}
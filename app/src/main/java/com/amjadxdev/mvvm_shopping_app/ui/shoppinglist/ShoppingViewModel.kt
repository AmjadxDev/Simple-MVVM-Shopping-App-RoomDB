package com.amjadxdev.mvvm_shopping_app.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem
import com.amjadxdev.mvvm_shopping_app.data.repository.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel(val shoppingRepository: ShoppingRepository) : ViewModel() {

    fun insertItem(item : ShoppingItem) = viewModelScope.launch { shoppingRepository.insertItem(item) }

    fun updateItem(item : ShoppingItem) = viewModelScope.launch { shoppingRepository.updateItem(item) }

    fun deleteItem(item : ShoppingItem) = viewModelScope.launch { shoppingRepository.deleteItem(item) }


    fun getShoppingAllItems() = shoppingRepository.getShoppingItems()

}
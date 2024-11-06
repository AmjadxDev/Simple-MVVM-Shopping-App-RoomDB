package com.amjadxdev.mvvm_shopping_app.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amjadxdev.mvvm_shopping_app.data.repository.ShoppingRepository

class ShoppingViewModelFactory(val shoppingRepository: ShoppingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepository) as T
    }
}
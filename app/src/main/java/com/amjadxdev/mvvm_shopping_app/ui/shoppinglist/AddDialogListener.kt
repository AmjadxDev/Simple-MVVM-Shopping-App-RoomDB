package com.amjadxdev.mvvm_shopping_app.ui.shoppinglist

import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem

interface AddDialogListener
{
    fun onAddButtonClicked(item : ShoppingItem)
}
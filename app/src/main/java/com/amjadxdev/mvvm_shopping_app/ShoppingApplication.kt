package com.amjadxdev.mvvm_shopping_app

import android.app.Application
import android.content.Context
import com.amjadxdev.mvvm_shopping_app.data.database.ShoppingDatabase
import com.amjadxdev.mvvm_shopping_app.data.repository.ShoppingRepository


class ShoppingApplication : Application() {

    companion object
    {
        fun shoppingRepo(context : Context) : ShoppingRepository {
            val shoppingDao = ShoppingDatabase.createDatabase(context).shoppingDao()
            return ShoppingRepository(shoppingDao)
        }

    }




}
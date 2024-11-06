package com.amjadxdev.mvvm_shopping_app.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item : ShoppingItem)

    @Update
    suspend fun updateItem(item : ShoppingItem)

    @Delete
    suspend fun deleteItem(item : ShoppingItem)
}
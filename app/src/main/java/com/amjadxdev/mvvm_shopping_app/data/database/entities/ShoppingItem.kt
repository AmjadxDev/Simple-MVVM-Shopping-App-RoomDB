package com.amjadxdev.mvvm_shopping_app.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "shopping_items")
data class ShoppingItem(
    @ColumnInfo(name = "item_name") var name: String,
    @ColumnInfo(name = "item_amount") var amount: Int
){
    @PrimaryKey(autoGenerate = true) var id : Long? = null
}

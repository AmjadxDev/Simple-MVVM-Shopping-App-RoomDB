package com.amjadxdev.mvvm_shopping_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amjadxdev.mvvm_shopping_app.Utils.DATABASE_VERSION
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = DATABASE_VERSION)
abstract class ShoppingDatabase() : RoomDatabase() {

    abstract fun shoppingDao() : ShoppingDao


    companion object{
        @Volatile
        private var INSTANCE : ShoppingDatabase? = null

        fun createDatabase(context : Context) : ShoppingDatabase {
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ShoppingDatabase::class.java,
                        "ShoppingDB.db").build()
                }
            }

            return INSTANCE!!

        }

    }

}
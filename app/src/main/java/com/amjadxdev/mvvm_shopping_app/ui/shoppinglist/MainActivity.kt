package com.amjadxdev.mvvm_shopping_app.ui.shoppinglist

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amjadxdev.mvvm_shopping_app.ShoppingApplication
import com.amjadxdev.mvvm_shopping_app.ShoppingApplication.Companion.shoppingRepo
import com.amjadxdev.mvvm_shopping_app.data.database.ShoppingDao
import com.amjadxdev.mvvm_shopping_app.data.database.ShoppingDatabase
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem
import com.amjadxdev.mvvm_shopping_app.data.repository.ShoppingRepository
import com.amjadxdev.mvvm_shopping_app.databinding.ActivityMainBinding
import com.amjadxdev.mvvm_shopping_app.others.ShoppingItemAdapter


class MainActivity : AppCompatActivity() {
    private val viewBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private lateinit var mainViewModel: ShoppingViewModel



    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)



        mainViewModel = ViewModelProvider(this@MainActivity, ShoppingViewModelFactory(
            shoppingRepo(this@MainActivity)))[ShoppingViewModel::class.java]


        val adapter =  ShoppingItemAdapter(listOf(), mainViewModel)
        viewBinding.recyclerView.adapter = adapter

        mainViewModel.getShoppingAllItems().observe(this@MainActivity, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        viewBinding.fab.setOnClickListener {
            AddShoppingItemDialog(this@MainActivity, object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    mainViewModel.insertItem(item)
                }

            }).show()

        }

    }

}
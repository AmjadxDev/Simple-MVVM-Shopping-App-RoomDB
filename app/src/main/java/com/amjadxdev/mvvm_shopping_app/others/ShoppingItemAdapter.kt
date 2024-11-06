package com.amjadxdev.mvvm_shopping_app.others

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem
import com.amjadxdev.mvvm_shopping_app.databinding.ShoppingItemBinding
import com.amjadxdev.mvvm_shopping_app.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel : ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>()
{

    inner class ShoppingItemViewHolder(val binding : ShoppingItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingItemAdapter.ShoppingItemViewHolder {
        return ShoppingItemViewHolder(ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: ShoppingItemAdapter.ShoppingItemViewHolder,
        position: Int
    ) {
        val currentShoppingItemName = items[position]
        holder.binding.apply {
            tvName.text = currentShoppingItemName.name
            tvAmount.text = currentShoppingItemName.amount.toString()


            ivDelete.setOnClickListener {
                viewModel.deleteItem(currentShoppingItemName)
            }

            ivMinus.setOnClickListener{
                if (currentShoppingItemName.amount > 0) {
                    currentShoppingItemName.amount--
                    viewModel.insertItem(currentShoppingItemName)
                }
            }

            ivPlus.setOnClickListener {
                currentShoppingItemName.amount++
                viewModel.insertItem(currentShoppingItemName)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
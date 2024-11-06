package com.amjadxdev.mvvm_shopping_app.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.amjadxdev.mvvm_shopping_app.R
import com.amjadxdev.mvvm_shopping_app.data.database.entities.ShoppingItem
import com.amjadxdev.mvvm_shopping_app.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(
    context : Context,
    var addDialogListener : AddDialogListener
) : AppCompatDialog(context)
{
    private val dialogBinding by lazy { DialogAddShoppingItemBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dialogBinding.root)

        dialogBinding.apply {
            tvAdd.setOnClickListener {
                val name = etName.text.toString()
                val amount = etAmount.text.toString()

                if (name.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val item = ShoppingItem(name, amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }

            tvCancel.setOnClickListener {
                cancel()
            }

        }
    }
}
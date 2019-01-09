package com.test.roomsample.view

import android.app.AlertDialog
import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import com.test.roomsample.R
import com.test.roomsample.model.AppDatabase
import com.test.roomsample.model.User


class UserDialog(var mContext: Context) {


    fun addNewUserDetails(dialog_layout: Int) {
        val inflater = LayoutInflater.from(mContext)
        val subView = inflater.inflate(dialog_layout, null)

        val nameField = subView.findViewById(R.id.enter_message) as EditText

        val builder = AlertDialog.Builder(mContext)
        builder.setTitle("Add new message")
        builder.setView(subView)
        builder.create()
        builder.setPositiveButton("ADD MESSAGE") { _, _ ->
            val message = nameField.text.toString()
            if (TextUtils.isEmpty(message)) {
                Toast.makeText(mContext, "Empty or invalid input", Toast.LENGTH_LONG).show()
            } else {
                val content = User(message)
                val userDao = AppDatabase.getInstance(mContext).userDetails()
                userDao.insertNewUser(content)
            }
        }
        builder.setNegativeButton("CANCEL") { dialog, which -> Toast.makeText(mContext, "Task cancelled", Toast.LENGTH_LONG).show() }
        builder.show()
    }
}
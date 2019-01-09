package com.test.roomsample.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.test.roomsample.R
import com.test.roomsample.model.AppDatabase
import com.test.roomsample.model.User
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.util.*

class UserAdapter(private val context: Context, private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    private fun getCurrentDateTime(): String {
        val fmt = DateTimeFormat.forPattern("MM/dd/YYYY")
        return fmt.print(DateTime(Date()))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val message = userList[position]

        holder.mTxtUserContent.text = message.content
        holder.mTxtUserDate.text = getCurrentDateTime()

        holder.mImgUserDelete.setOnClickListener {
            val messageDao = AppDatabase.getInstance(context).userDetails()
            messageDao.deleteUserDetails(message)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var mTxtUserContent: TextView = itemView.findViewById(R.id.txtUserContent)
        internal var mTxtUserDate: TextView = itemView.findViewById(R.id.txtUserDate)
        internal var mImgUserDelete: ImageView = itemView.findViewById(R.id.imgUserDelete)

    }
}

package com.test.roomsample.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.test.roomsample.R
import com.test.roomsample.database.UserDao
import com.test.roomsample.model.AppDatabase
import kotlinx.android.synthetic.main.activity_room.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        initSetupUserDetails()
    }

    private fun initSetupUserDetails() {

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        userRecyclerView.layoutManager = linearLayoutManager
        userRecyclerView.setHasFixedSize(true)

        val userDao = AppDatabase.getInstance(applicationContext).userDetails() as UserDao
        userDao.allUserDetails.observe(this, Observer { it ->
            it?.let {
                userRecyclerView.adapter = UserAdapter(this, it!!)
            }
        })

        fbAddUser.setOnClickListener {
            val dialog = UserDialog(this)
            dialog.addNewUserDetails(R.layout.dialog_layout)
        }
    }
}

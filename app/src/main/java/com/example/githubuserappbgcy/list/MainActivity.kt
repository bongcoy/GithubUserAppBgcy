package com.example.githubuserappbgcy.list

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuserappbgcy.R
import com.example.githubuserappbgcy.databinding.ActivityMainBinding
import com.example.githubuserappbgcy.detail.DetailActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataFollower: IntArray
    private lateinit var dataFollowing: IntArray
    private lateinit var dataRepository: IntArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>

    private val activityTitle : String = "Github User's"

    private var users = arrayListOf<User>()

    private fun prepareData(){
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataFollower = resources.getIntArray(R.array.followers)
        dataFollowing = resources.getIntArray(R.array.following)
        dataRepository = resources.getIntArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
    }

    private fun addItem() {
        for (position in dataName.indices){
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollower[position],
                dataFollowing[position],
                dataAvatar.getResourceId(position,-1)
            )
            users.add(user)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(activityTitle)

        binding.rvUsers.setHasFixedSize(true)
        prepareData()
        addItem()

        showRecyclerList()
    }

    private fun showRecyclerList() {
        val listUserAdapter = ListUserAdapter(users)

        binding.apply {
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUsers.adapter = listUserAdapter
        }

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(item: User) {
                showSelectedUser(item)
                moveToDetail(item)
            }
        })
    }

    private fun moveToDetail(user: User) {
        val moveIntent = Intent(this, DetailActivity::class.java)
        moveIntent.putExtra(DetailActivity.EXTRA_USER,user)
        startActivity(moveIntent)
    }

    private fun showSelectedUser(user: User) {
        Toast.makeText(this, user.username + " clicked !", Toast.LENGTH_SHORT).show()
    }

    private fun setActionBarTitle(title : String) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
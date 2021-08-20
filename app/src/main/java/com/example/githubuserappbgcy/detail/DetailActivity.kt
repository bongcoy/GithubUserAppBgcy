package com.example.githubuserappbgcy.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.githubuserappbgcy.databinding.ActivityDetailBinding
import com.example.githubuserappbgcy.list.User

class DetailActivity : AppCompatActivity() {
    private val activityTitle: String = "Detail User"
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBarTitle(activityTitle)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        Glide.with(this)
            .load(user.avatar)
            .into(binding.ivUserProfile)

        binding.apply {
            tvUsername.text = user.username
            tvName.text = user.name
            tvFollowerNumber.text = user.followers.toString()
            tvFollowingNumber.text = user.followings.toString()
            tvRepositoryNumber.text = user.repository.toString()
            tvCompany.text = user.company
            tvLocation.text = user.location
        }
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
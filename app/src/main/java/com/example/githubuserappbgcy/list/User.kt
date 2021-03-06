package com.example.githubuserappbgcy.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val username: String,
    val name: String,
    val location: String,
    val repository: Int,
    val company: String,
    val followers: Int,
    val followings: Int,
    val avatar: Int
) : Parcelable

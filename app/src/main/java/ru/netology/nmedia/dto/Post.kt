package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likesCount: Int = 999,
    var likedByMe: Boolean = false,
    var sharesCount: Int = 999
)
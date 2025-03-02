package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likesCount: Int = 999,
    val likedByMe: Boolean = false,
    val sharesCount: Int = 999
) {
    fun withLikesCount(newLikesCount: Int): Post {
        return this.copy(likesCount = newLikesCount)
    }

    fun withLikedByMe(newLikedByMe: Boolean): Post {
        return this.copy(likedByMe = newLikedByMe)
    }

    fun withShares(newShares: Int): Post {
        return this.copy(sharesCount = newShares)
    }
}

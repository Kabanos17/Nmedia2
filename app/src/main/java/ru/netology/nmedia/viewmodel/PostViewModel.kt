package ru.netology.nmedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.dto.Post

class PostViewModel : ViewModel() {
    private val _data = MutableLiveData<Post>()
    val data: LiveData<Post> = _data

    init {
        _data.value = Post(
            id = 1, author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36"
        )
    }

    fun like() {
        _data.value?.let { post ->
            val newLikedByMe = !post.likedByMe
            val newLikesCount = if (newLikedByMe) post.likesCount + 1 else post.likesCount - 1
            _data.value = post.withLikedByMe(newLikedByMe).withLikesCount(newLikesCount)
        }
    }

    fun share() {
        _data.value?.let { post ->
            _data.value = post.withShares(post.sharesCount + 1)
        }
    }
}

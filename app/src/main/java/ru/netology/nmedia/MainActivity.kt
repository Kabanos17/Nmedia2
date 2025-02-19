package ru.netology.nmedia

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            likes = 1099,
            shares = 999999
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            updateLikeButton(binding)
            likeCount.text = formatCount(post.likes)
            shareCount.text = formatCount(post.shares)

            root.setOnClickListener {
                Log.d("PostActions", "Root clicked")
            }

            like.setOnClickListener {
                toggleLike(binding)
            }

            share.setOnClickListener {
                post.shares++
                shareCount.text = formatCount(post.shares)
                Log.d("PostActions", "Post shared. Total shares: ${post.shares}")
            }
        }
    }

    private fun toggleLike(binding: ActivityMainBinding) {
        post.likedByMe = !post.likedByMe
        if (post.likedByMe) {
            post.likes++
        } else {
            post.likes--
        }
        updateLikeButton(binding)
        binding.likeCount.text = formatCount(post.likes)
        Log.d("PostActions", "Post liked: ${post.likedByMe}. Total likes: ${post.likes}")
    }

    private fun updateLikeButton(binding: ActivityMainBinding) {
        binding.like.setImageResource(
            if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
        )
    }

    fun formatCount(count: Int): String {
        return when {
            count < 1000 -> count.toString() // Если меньше 1000, просто возвращаем число
            count in 1000..9999 -> {
                // Для диапазона от 1000 до 9999 отображаем дробную часть
                val hundreds = count / 100 // Получаем количество сотен
                val thousands = count / 1000 // Получаем количество тысяч
                val decimalPart = (count % 1000) / 100 // Получаем дробную часть
                "$thousands.$decimalPart К" // Форматируем как "1.1К"
            }

            count >= 10000 -> {
                // Для 10К и выше просто отображаем количество тысяч
                val thousands = count / 1000
                "$thousands К" // Форматируем как "10К"
            }

            else -> count.toString() // На всякий случай
        }

    }
}


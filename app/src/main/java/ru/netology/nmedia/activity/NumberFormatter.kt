package ru.netology.nmedia.activity

class NumberFormatter {

    fun formatCount(count: Int): String {
        return when {
            count < 1000 -> {
                count.toString()
            }

            count < 10_000 -> {
                val thousands = count / 1000
                val decimalPart = (count % 1000) / 100
                "$thousands.$decimalPart К"
            }

            else -> {
                val thousands = count / 1000
                "$thousands К"
            }
        }
    }
}


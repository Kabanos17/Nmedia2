package ru.netology.nmedia.activity

class NumberFormatter {

    fun formatCount(count: Int): String {
        return when {
            count < 1000 -> count.toString()
            count in 1000..9999 -> {
                val hundreds = count / 100
                val thousands = count / 1000
                val decimalPart = (count % 1000) / 100
                "$thousands.$decimalPart К"
            }

            count >= 10000 -> {
                val thousands = count / 1000
                "$thousands К"
            }

            else -> count.toString()
        }
    }
}
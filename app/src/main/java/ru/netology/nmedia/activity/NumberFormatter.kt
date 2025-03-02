package ru.netology.nmedia.activity

/**
 * Класс для форматирования чисел, используемых для отображения лайков и репостов.
 */
class NumberFormatter {

    /**
     * Форматирует количество лайков или репостов в удобочитаемый вид.
     * Например, 1500 будет отображаться как "1.5 К", а 10000 как "10 К".
     */
    fun formatCount(count: Int): String {
        return when {
            count < 1000 -> {
                count.toString() // Возвращаем число как строку, если меньше 1000
            }

            count < 10000 -> {
                val thousands = count / 1000
                val decimalPart = (count % 1000) / 100
                "$thousands.$decimalPart К" // Форматируем числа от 1000 до 9999
            }

            else -> {
                val thousands = count / 1000000
                "$thousands М" // Форматируем числа 10000 и больше
            }
        }
    }
}
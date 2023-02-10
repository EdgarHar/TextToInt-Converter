package com.example.mobile_homework1

class TextToIntegerConverter() {
    val basics = mapOf(
        0 to "",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
    )

    val ten = mapOf(
        0 to "",
        1 to "",
        2 to "twenty",
        3 to "thirty",
        4 to "forty",
        5 to "fifty",
        6 to "sixty",
        7 to "seventy",
        8 to "eighty",
        9 to "ninety",
    )

    fun int2text(n: Int): String {
        if (n == 0) return "zero"

        val millionCount = n / 1_000_000
        val thousandCount = (n / 1_000) % 1_000

        return "${hundreds(millionCount)} ${if (millionCount == 0) "" else "million"} ${
            hundreds(
                thousandCount
            )
        }" +
                " ${if (thousandCount == 0) "" else "thousand"} ${hundreds(n % 1000)}"
    }

    fun hundreds(n: Int): String {

        val hundred = n / 100;
        val rest = n % 100;
        if (hundred == 0) {
            return doubleDigit(n)
        }
        return "${basics[hundred]} hundred ${doubleDigit(rest)}"
    }

    fun doubleDigit(n: Int): String {
        var result = "";
        if (n >= 20) {
            result += ten[n / 10] + " "
            result += basics[n % 10]
        } else {
            result = basics[n]!!;
        }

        return result;
    }
}
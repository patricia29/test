package com.example.bookstore.util

class Util {
    fun StringJoin(stringList: List<String>, delimeter: String?): String {
        val sb = StringBuilder()
        for (i in stringList.indices) {
            sb.append(stringList[i])
            if (i != stringList.size - 1) {
                sb.append(delimeter)
            }
        }
        return sb.toString()
    }
}
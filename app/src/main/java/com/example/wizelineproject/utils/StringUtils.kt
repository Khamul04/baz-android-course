package com.example.wizelineproject.utils

fun String.addCurrencySymbol(): String {
    return "$" + this
}

fun String.getFirstCurrencyName(): String {
    val strings = this.split("_")
    if (strings.size != 2) return ""
    return strings[0]
}

fun String.getSecondCurrencyName(): String {
    val strings = this.split("_")
    if (strings.size != 2) return ""
    return strings[1]
}

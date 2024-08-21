package com.a3fun.label

fun normalReturn() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // 非局部直接返回到 foo() 的调用者
        print(it)
    }
    println("this point is unreachable")
}

fun returnWithLabel() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 局部返回到 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }

    print(" done with explicit label")
}

fun returnWithImplicitLabel() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 局部返回到 lambda 表达式的调用者，即 forEach 循环
        print(it)
    }

    print(" done with implicit label")
}

fun main() {
    normalReturn()
    println()
    returnWithLabel()
    println()
    returnWithImplicitLabel()
}
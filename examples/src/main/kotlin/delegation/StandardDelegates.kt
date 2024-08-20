package com.a3fun.delegation

/**
 * The Kotlin standard library contains a bunch of useful delegates, like lazy, observable, and others. You may use them as is. For example lazyis used for lazy initialization.
 * 1. Property lazy is not initialized on object creation.
 * 2. The first call to get() executes the lambda expression passed to lazy() as an argument and saves the result.
 * 3. Further calls to get() return the saved result.
 * If you want thread safety, use blockingLazy() instead: it guarantees that the values will be computed only in one thread and that all threads will see the same value.
 */
class LazySample {
    init {
        println("created!")            // 1
    }

    val lazyStr: String by lazy {
        println("computed!")          // 2
        "my lazy"
    }
}

fun main() {
    val sample = LazySample()         // 1
    println("lazyStr = ${sample.lazyStr}")  // 2
    println(" = ${sample.lazyStr}")  // 3
}

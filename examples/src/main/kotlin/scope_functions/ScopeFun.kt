package com.a3fun.functional

class ScopeFun {
    fun alsoFun() {
        val intList: List<Int> = arrayListOf(1, 2, 3)
        intList.also {
            println(it.size) //3
            println(it.lastIndex)
        }

        val list2: List<Int>? = null
        list2?.also {
            println(it.size)
        }
    }

    fun applyFun() {
        val person = Person(
            name = "lisi",
            age = 19
        ).apply {
            age = 20
        }
        println(person)
    }

    fun letFun() {
        //let{}中可以使用it来代表intList对象
        val intList: List<Int> = arrayListOf(1, 2, 3)
        intList.let {
            println(it.size) //3
            println(it.lastIndex) //2
        }

        //通过?.let{}进行判断，如何为空，后面就不会再执行
        val list2: List<Int>? = null
        list2?.let {
            println(it.size)
        }
    }

    fun runFun() {
        val list = arrayListOf(1, 2, 3)
        val size = list.run {
            list.add(4) //添加一条数据
            list.size  //返回最终的size
        }
        println("list.size:$size") //执行结果：list.size:4
    }

    fun withFun() {
        val person = Person("zhangsan", 20)
        with(person) {
            println(name) //zhangsan
            println(age) //20
        }
    }

}

data class Person(var name: String, var age: Int)

fun main() {
    val scopeFun = ScopeFun()
    scopeFun.alsoFun()
    scopeFun.applyFun()
    scopeFun.letFun()
    scopeFun.runFun()
    scopeFun.withFun()
}
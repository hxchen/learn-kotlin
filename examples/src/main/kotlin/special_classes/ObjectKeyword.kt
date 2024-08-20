package com.a3fun.special_classes

/**
 * Demo 1
 * Object Expressions
 * 1. Creates a function with parameters.
 * 2. Creates an object to use when calculating the result value.
 * 3. Accesses the object's properties.
 * 4. Prints the result.
 * 5. Calls the function. This is when the object is actually created.
 */
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total \n")                                               //4

}

/**
 * Demo 2
 * Object Declarations
 * 1. Creates an object declaration.
 * 2. Defines the object method.
 * 3. Calls the method. This is when the object is actually created.
 */
object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {        //2
        println("input Auth parameters = $username:$password \n")
    }
}

/**
 * Demo 3
 * Companion Objects
 * 1. Defines a class.
 * 2. Defines a companion. Its name can be omitted.
 * 3. Defines a companion object method.
 * 4. Calls the companion object method via the class name.
 */
class BigBen {                                  //1
    companion object Bonger {                   //2
        fun getBongs(nTimes: Int) {             //3
            for (i in 1 .. nTimes) {
                print("BONG ")
            }
        }
    }
}



fun main() {
    // Calls the function. This is when the object is actually created.
    rentPrice(10, 2, 1)
    // Calls the method. This is when the object is actually created.
    DoAuth.takeParams("foo", "qwerty")
    // Calls the companion object method via the class name.
    BigBen.getBongs(12)
}
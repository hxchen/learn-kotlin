package com.a3fun.Collections

import kotlin.math.abs

/**
 * map extension function enables you to apply a transformation to all elements in a collection. It takes a transformer function as a lambda-parameter.
 */
fun map() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)     // 1

    val doubled = numbers.map { x -> x * 2 }      // 2

    val tripled = numbers.map { it * 3 }          // 3

    println("Numbers: $numbers")
    println("Doubled Numbers: $doubled")
    println("Tripled Numbers: $tripled")
}

/**
 * Function any returns true if the collection contains at least one element that matches the given predicate.
 */
fun any() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)    // 1

    val anyNegative = numbers.any { it < 0 }      // 2

    val anyGT6 = numbers.any { it > 6 }           // 3

    println("Numbers: $numbers")
    println("Is there any number less than 0: $anyNegative")
    println("Is there any number greater than 6: $anyGT6")
}

/**
 * Function all returns true if all elements in collection match the given predicate.
 */
fun all() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)    // 1

    val allEven = numbers.all { it % 2 == 0 }     // 2

    val allLess6 = numbers.all { it < 6 }         // 3

    println("Numbers: $numbers")
    println("All numbers are even: $allEven")
    println("All numbers are less than 6: $allLess6")
}

/**
 * Function none returns true if there are no elements that match the given predicate in the collection.
 */
fun none() {

    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val allEven = numbers.none { it % 2 == 1 }           // 2

    val allLess6 = numbers.none { it > 6 }               // 3

    println("Numbers: $numbers")
    println("All numbers are even: $allEven")
    println("No element greater than 6: $allLess6")
}

/**
 * The find and findLast functions return the first or the last collection element that matches the given predicate. If there are no such elements, these functions return null.
 */
fun find() {

    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")  // 1

    val first = words.find { it.startsWith("some") }                                // 2
    val last = words.findLast { it.startsWith("some") }                             // 3

    val nothing = words.find { it.contains("nothing") }                             // 4

    println("The first word starting with \"some\" is \"$first\"")
    println("The last word starting with \"some\" is \"$last\"")
    println("The first word containing \"nothing\" is ${nothing?.let { "\"$it\"" } ?: "null"}")
}

/**
 * These functions return the first and the last element of the collection correspondingly. You can also use them with a predicate; in this case, they return the first or the last element that matches the given predicate.
 * If a collection is empty or doesn't contain elements matching the predicate, the functions throw NoSuchElementException.
 */
fun firstAndLast() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val first = numbers.first()                          // 2
    val last = numbers.last()                            // 3

    val firstEven = numbers.first { it % 2 == 0 }        // 4
    val lastOdd = numbers.last { it % 2 != 0 }           // 5

    println("Numbers: $numbers")
    println("First $first, last $last, first even $firstEven, last odd $lastOdd")
}

/**
 * count functions returns either the total number of elements in a collection or the number of elements matching the given predicate.
 */
fun count() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)            // 1

    val totalCount = numbers.count()                     // 2
    val evenCount = numbers.count { it % 2 == 0 }        // 3

    println("Total number of elements: $totalCount")
    println("Number of even elements: $evenCount")
}

/**
 * Functions associateBy and groupBy build maps from the elements of a collection indexed by the specified key. The key is defined in the keySelector parameter. You can also specify an optional valueSelector to define what will be stored in the value of the map element.
 * The difference between associateBy and groupBy is how they process objects with the same key:
 * associateBy uses the last suitable element as the value.
 * groupBy builds a list of all suitable elements and puts it in the value.
 * The returned map preserves the entry iteration order of the original collection.
 *
 */
fun associateByAndGroupBy() {
    data class Person(val name: String, val city: String, val phone: String) // 1
    val people = listOf(                                                     // 2
        Person("John", "Boston", "+1-888-123456"),
        Person("Sarah", "Munich", "+49-777-789123"),
        Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
        Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

    val phoneBook = people.associateBy { it.phone }                          // 3
    val cityBook = people.associateBy(Person::phone, Person::city)           // 4
    val peopleCities = people.groupBy(Person::city, Person::name)            // 5
    val lastPersonCity = people.associateBy(Person::city, Person::name)      // 6


    println("People: $people")
    println("Phone book: $phoneBook")
    println("City book: $cityBook")
    println("People living in each city: $peopleCities")
    println("Last person living in each city: $lastPersonCity")
}

/**
 * 1. Defines a collection of numbers.
 * 2. Splits numbers into a Pair of lists with even and odd numbers.
 * 3. Splits numbers into two lists with positive and negative numbers. Pair destructuring is applied here to get the Pair members.
 */
fun partition() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)                // 1

    val evenOdd = numbers.partition { it % 2 == 0 }           // 2
    val (positives, negatives) = numbers.partition { it > 0 } // 3

    println("Numbers: $numbers")
    println("Even numbers: ${evenOdd.first}")
    println("Odd numbers: ${evenOdd.second}")
    println("Positive numbers: $positives")
    println("Negative numbers: $negatives")
}

/**
 * 1. Defines a collection of Strings with fruit names.
 * 2. Defines a collection of Strings with clothes names.
 * 3. Adds fruitsBag and clothesBag to the cart list.
 * 4. Builds a map of cart elements, which is a list of two lists.
 * 5. Builds a flatMap of cart elements, which is a single list consisting of elements from both lists.
 */
fun flatMap() {

    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
    val clothesBag = listOf("shirts","pants","jeans")           // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
    val mapBag = cart.map { it }                                // 4
    val flatMapBag = cart.flatMap { it }                        // 5

    println("Your bags are: $mapBag")
    println("The things you bought are: $flatMapBag")
}

/**
 * 1. For non-empty collection, functions return the smallest and the largest element.
 * 2. For empty collections, both functions return null.
 * 3. For collection with only one element, both functions return the same value.
 */
fun minOrNull() {
    val numbers = listOf(1, 2, 3)
    val empty = emptyList<Int>()
    val only = listOf(3)

    println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}") // 1
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")        // 2
    println("Only: $only, min = ${only.minOrNull()}, max = ${only.maxOrNull()}")            // 3
}

/**
 * 1. Defines a collection of shuffled numbers.
 * 2. Sorts it in the natural order.
 * 3. Sorts it in the inverted natural order by using -it as a selector function.
 * 4. Sorts it in the inverted natural order by using sortedDescending.
 * 5. Sorts it in the inverted natural order of items' absolute values by using abs(it) as a selector function.
 */
fun sorted() {
    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    val natural = shuffled.sorted()                             // 2
    val inverted = shuffled.sortedBy { -it }                    // 3
    val descending = shuffled.sortedDescending()                // 4
    val descendingBy = shuffled.sortedByDescending { abs(it)  } // 5

    println("Shuffled: $shuffled")
    println("Natural order: $natural")
    println("Inverted natural order: $inverted")
    println("Inverted natural order value: $descending")
    println("Inverted natural order of absolute values: $descendingBy")
}

/**
 * 1. Returns 42 because it's the value corresponding to the key "key".
 * 2. Returns null because "key2" is not in the map.
 * 3. Returns the default value because "key2" is absent. For this key it's 4.
 * 4. Throws NoSuchElementException because "anotherKey" is not in the map.
 */
fun mapElementAccess() {
    val map = mapOf("key" to 42)

    val value1 = map["key"]                                     // 1
    val value2 = map["key2"]                                    // 2

    val value3: Int = map.getValue("key")                       // 1

    val mapWithDefault = map.withDefault { k -> k.length }
    val value4 = mapWithDefault.getValue("key2")                // 3

    try {
        map.getValue("anotherKey")                              // 4
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }


    println("value1 is $value1")
    println("value2 is $value2")
    println("value3 is $value3")
    println("value4 is $value4")
}

/**
 * zip function merges two given collections into a new collection. By default, the result collection contains Pairs of source collection elements with the same index. However, you can define your own structure of the result collection element.
 * The size of the result collection equals to the minimum size of a source collection.
 * 1. Defines two collections.
 * 2. Merges them into a list of pairs. The infix notation is used here.
 * 3. Merges them into a list of String values by the given transformation.
 */
fun zip() {
    val A = listOf("a", "b", "c")                  // 1
    val B = listOf(1, 2, 3, 4)                     // 1

    val resultPairs = A zip B                      // 2
    val resultReduce = A.zip(B) { a, b -> "$a$b" } // 3

    println("A to B: $resultPairs")
    println("\$A\$B: $resultReduce")
}

fun getOrElse() {
    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { 42 })    // 1
    println(list.getOrElse(10) { 42 })   // 2

    val map = mutableMapOf<String, Int?>()
    println(map.getOrElse("x") { 1 })       // 1

    map["x"] = 3
    println(map.getOrElse("x") { 1 })       // 2

    map["x"] = null
    println(map.getOrElse("x") { 1 })       // 3
}
fun main() {
    zip()
}
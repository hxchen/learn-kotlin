package com.a3fun.Collections

/**
 * 1. Creates a MutableList.
 * 2. Creates a read-only view of the list.
 * 3. Adds a new item to the MutableList.
 * 4. A function that returns an immutable List.
 * 5. Updates the MutableList. All related read-only views are updated as well since they point to the same object.
 * 6. Retrieves the size of the read-only list.
 * 7. Iterates the list and prints its elements.
 * 8. Attempting to write to the read-only view causes a compilation error.
 */
val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)        // 1
val sudoers: List<Int> = systemUsers                              // 2

fun addSystemUser(newUser: Int) {                                 // 3
    systemUsers.add(newUser)
}

fun getSysSudoers(): List<Int> {                                  // 4
    return sudoers
}

fun main() {
    addSystemUser(4)                                              // 5
    println("Tot sudoers: ${getSysSudoers().size}")               // 6
    getSysSudoers().forEach {                                     // 7
            i -> println("Some useful info on user $i")
    }
//     getSysSudoers().add(5) <- Error!                           // 8
}
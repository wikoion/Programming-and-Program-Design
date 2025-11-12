import java.math.BigInteger

/**
 * MAIN PROGRAM ENTRY POINT
 * Interactive command-line utility for:
 * 1. Sum of cubes (1³ + 2³ + ... + n³)
 * 2. Temperature conversion (C, F, K)
 * 3. Sum of three factorials (n1! + n2! + n3!)
 */
fun main() {
    // Display welcome banner for user engagement
    println("#######################################################")
    println("Welcome to the Interactive Kotlin Command-Line Utility!")
    println("#######################################################")

    // Main command loop — continues until 'exit' or 'quit'
    while (true) {
        println("\nAvailable commands: Sum | Conversion | Factorial | Exit")
        print("Enter command: ")
        val command = readLine()?.trim()?.lowercase() ?: ""  // Safe null handling

        // Route command to appropriate handler
        when (command) {
            "sum" -> handleSumCommand()                                 // Sum of cubes
            "conversion" -> handleConversionCommand()                   // Temp conversion
            "factorial" -> handleFactorialCommand()                     // Sum of factorials
            "exit", "quit" -> {
                println("Exiting the application. Goodbye!")
                break                                                   // Terminate loop
            }
            else -> println("Error: '$command'. Please use: Sum, Conversion, Factorial, or Exit")
        }
    }
}

/**
 * HANDLER: Sum of Cubes
 * Accepts natural number (n > 0), computes 1³ + 2³ + ... + n³
 * Supports 'back' to return to main menu
 */
private fun handleSumCommand() {
    println("Enter a natural number to calculate the sum of cubes.")
    println("Or type 'back' to return.\n")

    while (true) {
        print("Sum> ")
        val input = readLine()?.trim() ?: return  // EOF or null → return to main

        if (input.equals("back", ignoreCase = true)) {
            println("Returning to main menu...")
            return
        }

        if (input.isBlank()) {
            println("Error: Input cannot be empty. Try again or type 'back'.")
            continue
        }

        val n = input.toIntOrNull()
        if (n == null || n <= 0) {
            println("Error: Please enter a natural number. Try again or type 'back'.")
            continue
        }

        val result = calculateSumOfCubes(n)
        println("Sum of cubes from 1^3 to $n^3 = $result")
        return  // Success → exit loop
    }
}

/**
 * UTILITY: Calculate sum of cubes using iterative method
 * Time complexity: O(n), Space: O(1)
 * Educational clarity over O(1) formula
 */
private fun calculateSumOfCubes(n: Int): Long {
    var sum = 0L
    for (i in 1..n) {
        sum += (i * i * i).toLong()  // Compute i³ and add to sum
    }
    return sum
}

/**
 * HANDLER: Temperature Conversion
 * Input format: "<temp> <from> <to>" (e.g., "32 F C")
 * Full validation with per-field error messages
 */
private fun handleConversionCommand() {
    println("Enter temperature value | Source unit (C/F/K) | Target unit (C/F/K).")
    println("Or type 'back' to return.\n")

    while (true) {
        print("Conversion> ")
        val line = readLine()?.trim() ?: continue

        if (line.equals("back", ignoreCase = true)) {
            println("Returning to main menu...")
            return
        }
        if (line.isBlank()) {
            println("Error: Input cannot be empty. Try again or type 'back'.")
            continue
        }

        // Parse input into three parts
        val parts = line.split(" ").map { it.trim() }.filter { it.isNotEmpty() }
        if (parts.size != 3) {
            println("Error: Enter exactly 3 values: <temp> <from> <to>")
            println("Example: 32 F C")
            continue
        }

        // Validate temperature — preserve original input for error message
        val tempInput = parts[0]
        val temp = tempInput.toDoubleOrNull()
        if (temp == null) {
            println("Error: '$tempInput' is not a valid number.")
            continue
        }

        // Validate source and target units
        val from = parts[1].uppercase()
        val to = parts[2].uppercase()

        if (from !in listOf("C", "F", "K")) {
            println("Error: Source unit '$from' is invalid. Use C, F, or K.")
            continue
        }
        if (to !in listOf("C", "F", "K")) {
            println("Error: Target unit '$to' is invalid. Use C, F, or K.")
            continue
        }
        if (from == to) {
            println("Error: Source and target units cannot be the same.")
            continue
        }

        // Convert via Celsius as intermediate
        val celsius = when (from) {
            "C" -> temp
            "F" -> (temp - 32) * 5 / 9
            "K" -> temp - 273.15
            else -> 0.0
        }

        val result = when (to) {
            "C" -> celsius
            "F" -> celsius * 9 / 5 + 32
            "K" -> celsius + 273.15
            else -> 0.0
        }

        println("$temp $from = %.2f $to".format(result))
        return  // Success → exit loop
    }
}

/**
 * HANDLER: Sum of Three Factorials
 * Input: three non-negative integers (e.g., 3 4 5)
 * Output: n1! + n2! + n3! = f1 + f2 + f3 = sum
 */
private fun handleFactorialCommand() {
    println("Enter three non-negative integers (e.g., 3 4 5) to calculate sum of factorials.")
    println("Or type 'back' to return to main menu.\n")

    while (true) {
        print("Factorial> ")
        val line = readLine()?.trim() ?: continue

        if (line.equals("back", ignoreCase = true)) {
            println("Returning to main menu...")
            return
        }
        if (line.isBlank()) {
            println("Error: Input cannot be empty. Try again or type 'back'.")
            continue
        }

        val parts = line.split(" ").map { it.trim() }.filter { it.isNotEmpty() }
        if (parts.size != 3) {
            println("Error: Exactly THREE non-negative integers required. Example: 3 4 5")
            continue
        }

        // Validate each input individually
        val n1 = parts[0].toIntOrNull()
        val n2 = parts[1].toIntOrNull()
        val n3 = parts[2].toIntOrNull()

        if (n1 == null || n1 < 0) {
            println("Error: '${parts[0]}' is not a valid non-negative integer.")
            continue
        }
        if (n2 == null || n2 < 0) {
            println("Error: '${parts[1]}' is not a valid non-negative integer.")
            continue
        }
        if (n3 == null || n3 < 0) {
            println("Error: '${parts[2]}' is not a valid non-negative integer.")
            continue
        }

        // Compute factorials and sum
        val f1 = factorial(n1)
        val f2 = factorial(n2)
        val f3 = factorial(n3)
        val sum = f1 + f2 + f3

        // Display mathematical formula
        println("${n1}! + ${n2}! + ${n3}! = $f1 + $f2 + $f3 = $sum")
        return  // Success → exit loop
    }
}

/**
 * UTILITY: Factorial using Long
 * Safe for n ≤ 20 (20! fits in Long)
 * Base cases: 0! = 1, 1! = 1
 */
private fun factorial(n: Int): BigInteger {
    var result = BigInteger.ONE
    for (i in 2..n) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }
    return result
}
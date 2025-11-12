import java.math.BigInteger

fun main() {
    println("Welcome to the Interactive Kotlin Command-Line Utility!")
    println("Available commands: sum, conversion, factorial, exit")

    while (true) {
        print("\nEnter command: ")
        val command = readLine()?.trim()?.lowercase() ?: ""

        when (command) {
            "sum" -> handleSumCommand()
            "conversion" -> handleConversionCommand()
            "factorial" -> handleFactorialCommand()
            "exit" -> {
                println("Exiting the application. Goodbye!")
                break
            }
            else -> println("Invalid command. Please use: sum, conversion, factorial, or exit")
        }
    }
}

fun handleSumCommand() {
    println("Enter a natural number (positive integer) for sum of cubes:")
    val input = readLine()?.toIntOrNull()

    if (input == null || input <= 0) {
        println("Error: Please enter a positive integer.")
        return
    }

    val result = calculateSumOfCubes(input)
    println("Sum of cubes from 1^3 to $input^3 = $result")
}

fun calculateSumOfCubes(n: Int): Long {
    var sum = 0L
    for (i in 1..n) {
        sum += (i * i * i).toLong()
    }
    return sum
}

fun handleConversionCommand(){
    TODO()
}

fun handleFactorialCommand() {
    println("Enter three whole numbers separated by commas e.g.: 3, 4, 5):")
    val input = readLine()

    if (input.isNullOrBlank()) {
        println("Error: you need to enter some numbers.")
        return
    }

    val numbers = input.trim().split(", ")
    if (numbers.size != 3) {
        println("Error: please enter exactly three numbers separated by commas")
        return
    }

    val n1 = numbers[0].toIntOrNull()
    val n2 = numbers[1].toIntOrNull()
    val n3 = numbers[2].toIntOrNull()

    if (n1 == null || n2 == null || n3 == null || n1 < 0 || n2 < 0 || n3 < 0) {
        println("Error: all numbers must be non-negative integers")
        return
    }

    val result = factorial(n1, n2, n3)
    println("The sum of factorials is: $result")
}

fun factorial(n1: Int, n2: Int, n3:Int):BigInteger {
    require(n1 >= 0) { "First number must be non-negative" }
    require(n2 >= 0){ "Second must be non-negative" }
    require(n3 >= 0){ "Third must be non-negative" }

    fun calcFactorial(n: Int):BigInteger {
        var result = BigInteger.ONE
        for (i in 1..n) {
            result = result.multiply(BigInteger.valueOf(i.toLong()))
        }
        return result
    }
    return calcFactorial(n1) + calcFactorial(n2) + calcFactorial(n3)
}

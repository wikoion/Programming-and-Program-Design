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

fun handleFactorialCommand(n1: Int, n2: Int, n3:Int):BigInteger {
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
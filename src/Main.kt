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

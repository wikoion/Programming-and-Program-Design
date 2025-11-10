//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Welcome to the Interactive Kotlin Command-Line Utility!")
    println("Available commands: sum, conversion, factorial, exit")

    while (true) {
        print("\nEnter command: ")
        val command = readLine()?.trim()?.lowercase() ?: ""

        when (command) {
            "sum" -> handleSum()
            "conversion" -> handleConversion()
            "factorial" -> handleFactorial()
            "exit" -> {
                println("Exiting the application. Goodbye!")
                break
            }
            else -> println("Invalid command. Please use: sum, conversion, factorial, or exit")
        }
    }
}fun handleSum(parts: List<String>): Boolean {
    if (parts.size != 2) {
        println("Usage: sum <n>   (n > 0)")
        return true
    }

    val n = parts[1].toIntOrNull()
    if (n == null || n <= 0) {
        println("Error: '$parts[1]' is not a positive integer")
        return true
    }

    val result = sumOfCubes(n)
    println("Sum of cubes (1^3 + ... + $n^3) = $result")
    return true
}

fun sumOfCubes(n: Int): Long {
    val temp = n.toLong() * (n + 1) / 2
    return temp * temp

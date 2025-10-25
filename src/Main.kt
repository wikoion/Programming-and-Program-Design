import java.math.BigInteger

fun main() {
    println("Change ME")

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

//    println("${factorial(1,2,3)}")

}
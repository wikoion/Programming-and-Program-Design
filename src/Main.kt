fun main() {
    println("Change ME")

    fun factorial(n1: Int, n2: Int, n3:Int):Long {
        require(n1 >= 0) { "First number must be non-negative" }
        require(n2 >= 0){ "Second must be non-negative" }
        require(n3 >= 0){ "Third must be non-negative" }

        var res1 = n1
        var res2 = n2
        var res3 = n3

        fun calcFactorial(n: Int):Long {
            var result = 1L
            for(i in 1..n){
                result *= i
            }
            return result
        }
        return calcFactorial(res1) + calcFactorial(res2) + calcFactorial(res3)

    }
}
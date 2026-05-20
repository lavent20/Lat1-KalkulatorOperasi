fun applyOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val add: (Int, Int) -> Int = { x, y -> x + y }
    val sub: (Int, Int) -> Int = { x, y -> x - y }
    val mul: (Int, Int) -> Int = { x, y -> x * y }
    
    val div: (Int, Int) -> Int = { x, y ->
        if (y == 0) throw ArithmeticException("ERROR (division by zero)")
        x / y
    }

    data class TestCase(val a: Int, val b: Int, val opSymbol: String, val opFunc: (Int, Int) -> Int)

    val tests = listOf(
        TestCase(10, 5, "+", add),
        TestCase(10, 5, "-", sub),          
        TestCase(10, 5, "*", mul),          
        TestCase(10, 5, "/", div),          
        TestCase(10, 0, "/", div),
        TestCase(-8, 2, "/", div)
    )

    println("Output")
    
    for ((a, b, symbol, opFunc) in tests) {
        try {
            val result = applyOperation(a, b, opFunc)
            println("$a $symbol $b = $result")
        } catch (e: ArithmeticException) {
            println("$a $symbol $b = ${e.message}")
        }
    }
}

data class Contoh(val a: Int, val b: Int, val op: (Int, Int) -> Int, val simbol: String)

fun fungsiKalkulator(a: Int, b: Int, fungsi: (Int, Int) -> Int): Int {
    return fungsi(a, b)
}

fun main() {

    val add: (Int, Int) -> Int = { x, y -> x + y }
    val sub: (Int, Int) -> Int = { x, y -> x - y }
    val mul: (Int, Int) -> Int = { x, y -> x * y }

    val div: (Int, Int) -> Int = { x, y ->
        if (y == 0) {
            throw ArithmeticException("ERROR (division by zero)")
        }
        x / y
    }

    val tests = listOf(
        Contoh(10, 5, add, "+"),
        Contoh(10, 5, sub, "-"),
        Contoh(10, 5, mul, "*"),
        Contoh(10, 5, div, "/"),
        Contoh(10, 0, div, "/"),
        Contoh(-8, 2, div, "/")
    )

    for ((a, b, op, simbol) in tests) {
        try {
            val result = fungsiKalkulator(a, b, op)
            println("$a $simbol $b = $result")
        } catch (e: ArithmeticException) {
            println("$a $simbol $b = ${e.message}")
        }
    }
}

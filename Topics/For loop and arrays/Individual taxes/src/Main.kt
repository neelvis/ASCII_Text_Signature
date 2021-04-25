fun main() {
    val n = readLine()!!.toInt()
    val incomes = IntArray(n) { readLine()!!.toInt() }
    val taxes = IntArray(n) { readLine()!!.toInt() }
    var taxValues = DoubleArray(n) { incomes[it] * taxes[it] / 100.0 }
    print(taxValues.indexOf(taxValues.sorted().last()) + 1)
}
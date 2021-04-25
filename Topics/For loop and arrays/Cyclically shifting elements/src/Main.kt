fun main() {
    val count = readLine()!!.toInt()
    val numbers = IntArray(count) { readLine()!!.toInt() }
    var numbersNew = emptyArray<Int> ()
    numbersNew += numbers.last()
    for (c in 0 until count - 1) numbersNew += numbers[c]
    for (c in 0 until count) print("${numbersNew[c]} ")
}
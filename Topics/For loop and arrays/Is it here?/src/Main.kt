fun main() {
    val count = readLine()!!.toInt()
    val numbers = IntArray(count) { readLine()!!.toInt() }
    val m = readLine()!!.toInt()

    print(if (numbers.contains(m)) "YES" else "NO")
}
fun main() {
    val n = readLine()!!.toInt()
    val numbers = IntArray(n) { readLine()!!.toInt() }
    val m = readLine()!!.toInt()
    var res = 0

    for (e in numbers) {
        if (e == m) res++
    }

    print(res)
}
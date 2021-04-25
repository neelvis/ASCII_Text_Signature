fun main() {
    val n = readLine()!!.toInt()
    val numbers = IntArray(n) { readLine()!!.toInt() }
    val (pS, mS) = readLine()!!.split(' ')
    val p = pS.toInt()
    val m = mS.toInt()
    var result = "YES"

    for (e in 0 until numbers.lastIndex) {
        if(numbers[e] == p && numbers[e+1] == m ||
                numbers[e] == m && numbers[e+1] == p)
                    result = "NO"
    }
    print(result)
}
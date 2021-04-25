fun main() {
    val l = mutableListOf<Int>(0)
    do {
        val a = readLine()!!.toInt()
        if (a == 0) break
        l.add(a)
    } while(true)
    print(l.max()!!)
}
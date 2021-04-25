fun main() {
    // write your code here
    val size = readLine()!!.toInt()
    var arr = ArrayList<Int>(size)
    repeat(size) {
        arr.add(readLine()!!.toInt())
    }
    var count = 0
    for (i in 0..size - 3) if (arr[i] + 1 == arr[i + 1] && arr[i] + 2 == arr[i + 2]) count++
    print(count)
}
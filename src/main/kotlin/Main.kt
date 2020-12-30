fun main() {
    val sourceRad = readLine()!!.toInt()
    val number = if (sourceRad == 1) readLine()!!.length else readLine()!!.toInt(sourceRad)
    val changeRad = readLine()!!.toInt()

    println(if (changeRad == 1) "1".repeat(number) else number.toString(changeRad))
}
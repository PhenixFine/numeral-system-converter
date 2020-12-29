fun main() {
    val number = readLine()!!.toLongOrNull() ?: 0L
    val radixNum = readLine()!!.toIntOrNull() ?: 2
    val prefix =
        if (radixNum == 2) "0b" else if (radixNum == 8) "0" else if (radixNum == 16) "0x" else "${radixNum}B-"

    println(prefix + number.toString(radixNum))
}
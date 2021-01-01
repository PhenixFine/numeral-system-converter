import java.lang.Exception

fun main() {
    try {
        val sourceRad = readLine()!!.toInt()
        var number = if (sourceRad == 1) readLine()!!.length.toString() else readLine()!!
        val changeRad = readLine()!!.toInt()

        if (sourceRad != 10 && sourceRad != 1) number = toDecimal(number, sourceRad)
        if (changeRad == 1) number = "1".repeat(number.toInt()) else if (changeRad != 10) number =
            toBase(number, changeRad)
        println(number)
    } catch (e: Exception) {
        println("error")
    }
}

fun toDecimal(number: String, radix: Int): String {
    return if (number.contains('.')) {
        val decNumber = number.split('.')[0].toInt(radix).toDouble()
        var holdDigits = 0.0
        var times = radix.toDouble()

        for (char in number.split('.')[1]) {
            holdDigits +=
                ((if (char.isLetter()) char.toInt() - 87 else char.toString().toInt()) / times)
            times *= radix
        }
        (decNumber + holdDigits).toString()
    } else number.toInt(radix).toString()
}

fun toBase(number: String, radix: Int): String {
    return if (number.contains('.')) {
        var baseNumber = number.split('.')[0].toInt().toString(radix) + "."
        var holdDigits = ("0." + number.split('.')[1]).toDouble()

        repeat(5) {
            val holdResult = (radix * holdDigits).toString().split('.')

            baseNumber += if (holdResult[0].toInt() > 9) (holdResult[0].toInt() + 87).toChar()
                .toString() else holdResult[0]
            if (it != 4) holdDigits = ("0." + holdResult[1]).toDouble()
        }
        baseNumber
    } else number.toInt().toString(radix)
}
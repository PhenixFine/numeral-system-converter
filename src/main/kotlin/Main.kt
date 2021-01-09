fun main() {
    val sourceRad = getRange()
    var number = if (sourceRad == null) null else readLine()

    if (number != null && sourceRad != null) {
        when {
            sourceRad == 1 -> number = radOne(number)
            sourceRad != 10 -> number = toDecimal(number, sourceRad)
            number.toDoubleOrNull() == null -> number = null
        }
    }
    if (number != null) {
        val changeRad = getRange()

        if (changeRad != null) {
            if (changeRad == 1) number = "1".repeat(number.toDouble().toInt())
            else if (changeRad != 10) number = toBase(number, changeRad)
        } else number = null
    }
    println(number ?: "error")
}

fun getRange(): Int? {
    val holdNum = readLine() ?: return null
    return if ((1..36).contains(holdNum.toIntOrNull())) holdNum.toInt() else null
}

fun radOne(number: String): String? {
    for (char in number) if (char != '1') return null
    return number.length.toString()
}

fun toDecimal(number: String, radix: Int): String? {
    return if (number.contains('.')) {
        val decNumber = number.split('.')[0].toIntOrNull(radix) ?: return null
        var holdDigits = 0.0
        var times = radix.toDouble()

        for (char in number.split('.')[1]) {
            holdDigits += ((if (char.isLetter()) char.toLowerCase().toInt() - 87 else char.toString().toIntOrNull()
                ?: return null) / times)
            times *= radix
        }
        (decNumber + holdDigits).toString()
    } else (number.toIntOrNull(radix) ?: return null).toString()
}

fun toBase(number: String, radix: Int): String {
    return if (number.contains('.')) {
        var baseNumber = number.split('.')[0].toInt().toString(radix) + "."
        var holdDigits = ("0." + number.split('.')[1]).toDouble()

        repeat(5) {
            val holdResult = (radix * holdDigits).toString().split('.')

            baseNumber +=
                if (holdResult[0].toInt() > 9) (holdResult[0].toInt() + 87).toChar().toString() else holdResult[0]
            if (it != 4) holdDigits = ("0." + holdResult[1]).toDouble()
        }
        baseNumber
    } else number.toInt().toString(radix)
}
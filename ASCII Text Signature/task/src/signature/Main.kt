package signature

import java.io.File

val firstLine = "____.___ .____.___ .____.____.____._  _._. _._  _._   ._  _._  _.____.___ .____.____.____.___._  _._  _._ _ _._  _._   _.___ ".split(".")
val secondLine = "|__|.|__].|   .|  \\.|___.|___.| __.|__|.|. |.|_/ .|   .|\\/|.|\\ |.|  |.|__].|  |.|__/.[__ . | .|  |.|  |.| | |. \\/ . \\_/ .  / ".split(".")
val thirdLine = "|  |.|__].|___.|__/.|___.|   .|__].|  |.|._|.| \\_.|___.|  |.| \\|.|__|.|   .|_\\|.|  \\.___]. | .|__|. \\/ .|_|_|._/\\_.  |  . /__".split(".")

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val status = readLine()!!.toUpperCase()

    printWeirdestCard(name, status)
}

fun printWeirdestCard(name: String, status: String) {
    val wName = makeWeirdestFont(name).split("+")
    val wStatus = makeWeirdFont(status).split('.')

    val width = if (wName[0].length > wStatus[0].length) wName[0].length + 4 else wStatus[0].length + 4
    val horLine = "".padEnd(width + 4, '8')
    val nameLeftMargin = (width - wName[0].length) / 2
    val nameLeftSpaces = "".padEnd(nameLeftMargin, ' ')
    val nameRightMargin = width - wName[0].length - nameLeftMargin
    val nameRightSpaces = "".padEnd(nameRightMargin, ' ')
    val statusLeftMargin = (width - wStatus[0].length) / 2
    val statusLeftSpaces = "".padEnd(statusLeftMargin, ' ')
    val statusRightMargin = width - wStatus[0].length - statusLeftMargin
    val statusRightSpaces = "".padEnd(statusRightMargin, ' ')

    println(horLine)
    wName.forEach {
        println("88$nameLeftSpaces$it${nameRightSpaces}88")
    }
    wStatus.forEach {
        println("88$statusLeftSpaces$it${statusRightSpaces}88")
    }
    println(horLine)
}

fun makeWeirdestFont(name: String): String {
    var lines: ArrayList<String> = ArrayList(10)
    for (i in 0..9) lines.add("")

    val fontPath = "/home/pixel/roman.txt"
    val fontFile = File(fontPath)
    val letters = fontFile.readLines()

    var letterIndex = 0
    var letterInfo = 0
    var letterStart = 0
    var letter = '0'
    var width = '0'

    name.forEach {
        letterIndex = when (it) {
            ' ' -> 52
            in 'A'..'Z' -> it.toInt () - 39 // capital letters from 26 to 51
            in 'a'..'z' -> it.toInt() - 97 // small letters from 0 to 25
            else -> 0
        }
        letterInfo = letterIndex * 11 + 1
        letterStart = letterIndex * 11 + 2
        for (i in lines.indices) {
            lines[i] += letters[letterStart + i]
        }
    }

    return lines.joinToString("+")
}

fun makeWeirdFont(name: String): String {
    var line1 = ""
    var line2 = ""
    var line3 = ""
    name.forEach {
        if (it == ' ') {
            line1 += "     "
            line2 += "     "
            line3 += "     "
        } else {
            line1 += "${firstLine[it.toInt() - 65]} "
            line2 += "${secondLine[it.toInt() - 65]} "
            line3 += "${thirdLine[it.toInt() - 65]} "
        }
    }
    /*
    line1 = line1.dropLast(1)
    line2 = line2.dropLast(1)
    line3 = line3.dropLast(1)
     */
    return "$line1.$line2.$line3"
}

fun printWeirdCard(name: String, status: String) {
    val weirdName = makeWeirdFont(name).split('.')
    val width = if (weirdName[0].length > status.length) weirdName[0].length + 4 else status.length + 4
    val horLine = "".padEnd(width + 2, '*')
    val nameLeftMargin = (width - weirdName[0].length) / 2
    val nameLeftSpaces = "".padEnd(nameLeftMargin, ' ')
    val nameRightMargin = width - weirdName[0].length - nameLeftMargin
    val nameRightSpaces= "".padEnd(nameRightMargin, ' ')
    val statusLeftMargin = (width - status.length) / 2
    val statusLeftSpaces = "".padEnd(statusLeftMargin, ' ')
    val statusRightMargin = width - status.length - statusLeftMargin
    val statusRightSpaces = "".padEnd(statusRightMargin, ' ')
    print("""
        $horLine
        *$nameLeftSpaces${weirdName[0]}$nameRightSpaces*
        *$nameLeftSpaces${weirdName[1]}$nameRightSpaces*
        *$nameLeftSpaces${weirdName[2]}$nameRightSpaces*
        *$statusLeftSpaces$status$statusRightSpaces*
        $horLine
        
    """.trimIndent())
}

fun makeStarBusinessCard(name: String): String {
    val len = name.length
    val hor = "".padEnd(len + 4, '*')
    return "$hor\n* $name *\n$hor"
}

fun makeBusinessCard(name: String): String {
    val len = name.length
    val top = "".padEnd(len + 2, '_')
    val bottom = "".padEnd(len + 2, '•')
    return """
         $top
        | $name | 
         $bottom
    """.trimIndent()
}
fun main() {
    println(agoToText(1260)) // в секундах
}

const val ONE_MINUTE: Int = 60
const val ONE_HOUR: Int = 60*60
const val ONE_DAY: Int = 60*60*24

fun agoToText(lastAppearance: Int): String {

    val minutesCount = lastAppearance / ONE_MINUTE
    val hoursCount = lastAppearance / ONE_HOUR

    return when (lastAppearance) {
        in 0..ONE_MINUTE -> "был(а) только что"
        in ONE_MINUTE..ONE_HOUR -> "был(а) в сети $minutesCount ${minutesAgo(minutesCount)} назад"
        in ONE_HOUR..ONE_DAY -> "был(а) в сети $hoursCount ${hoursAgo(hoursCount)} назад"
        in ONE_DAY..ONE_DAY*2 -> "был(а) в сети сегодня"
        in ONE_DAY*2..ONE_DAY*3 -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

fun minutesAgo(minutesCount: Int): String {
    return when(minutesCount) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        else -> "минут"
    }
}

fun hoursAgo(hoursCount: Int): String {
    return when(hoursCount) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        else -> "часов"
    }
}
package ru.netology

fun main() {
    println("Задание № 1")
    agoToText(60)
//    agoToText (61)
//    agoToText (60 * 21)
//    agoToText (60 * 22)
//    agoToText (60 * 50)
//    agoToText (60 * 11)
//    agoToText (60 * 60 * 21)
//    agoToText (60 * 60 * 2)
//    agoToText (60 * 60 * 5)
//    agoToText (60 * 60 * 24)
//    agoToText (60 * 60 * 24 + 1)
//    agoToText (60 * 60 * 24 * 2)
//    agoToText (60 * 60 * 24 * 2 + 1)
//    agoToText (60 * 60 * 24 * 3)
//    agoToText (60 * 60 * 24 * 3 + 1)


    println("Задание № 2")
    val typeCard = "Mastercard"
    val transferPerMonth = 0
    val transferSum = 75_000
    val limitTransferPerDay = 150_000
    val limitTransferPerMonth = 600_000

    if (limitTransferPerDay >= transferSum && limitTransferPerMonth >= transferPerMonth + transferSum) {
        println("Операция проведена успешно, комиссия составила: " + transfer(typeCard, transferPerMonth, transferSum) + " руб")
    } else {
        println("Операция заблокирована!")
    }
}

// функция для ДЗ-2
fun transfer(typeCard: String, transferPerMonth: Int, transferSum: Int): Int {
    val commissionVisa = 0.0075
    val commissionMastercard = 0.006
    val minCommission = 35
    val maxSumNonCommissionMastercard = 75_000
    val addCommissionMastercard = 20
    when (typeCard) {
        "Visa" -> if (transferSum * commissionVisa < minCommission) {
            return minCommission
        } else {
            return (transferSum * commissionVisa).toInt()
        }

        "Mastercard" -> if (transferSum + transferPerMonth <= maxSumNonCommissionMastercard) {
            return 0
        } else if (maxSumNonCommissionMastercard - transferPerMonth >= 0) {
            return ((transferSum + transferPerMonth - maxSumNonCommissionMastercard) * commissionMastercard).toInt() + addCommissionMastercard
        } else {
            return (transferSum * commissionMastercard).toInt() + addCommissionMastercard
        }
    }
    return 0
}


// функция для ДЗ-1
fun agoToText(ago: Int) {

    if (ago <= 60) {
        println("был(а) только что")
    } else if (ago >= 61 && ago <= 60 * 60) {
        agoMin(ago / 60)
    } else if (ago >= 60 * 60 + 1 && ago <= 24 * 60 * 60) {
        agoHour(ago / 60 / 60)
    } else {
        agoDay(ago)
    }

}

// функция для ДЗ-1
fun agoMin(min: Int) {

    when (min % 10) {

        1 -> if (min != (10 + min % 10)) {
            println("был(а) " + min + " минуту назад")
        } else {
            println("был(а) " + min + " минут назад")
        }

        2, 3, 4 -> if (min != (10 + min % 10)) {
            println("был(а) " + min + " минуты назад")
        } else {
            println("был(а) " + min + " минут назад")
        }

        else -> {
            println("был(а) " + min + " минут назад")
        }

    }

}

// функция для ДЗ-1
fun agoHour(hour: Int) {

    when (hour) {

        1, 21 -> println("был(а) " + hour + " час назад")
        2, 3, 4, 22, 23, 24 -> println("был(а) " + hour + " часа назад")
        else -> println("был(а) " + hour + " часов назад")

    }

}

// функция для ДЗ-1
fun agoDay(day: Int) {

    when (day / 60 / 60 / 24) {
        1 -> println("был(а) вчера")
        2 -> if (day >= 60 * 60 * 24 * 2 + 1 && day <= 60 * 60 * 24 * 3) {
            println("был(а) позавчера")
        } else {
            println("был(а) вчера")
        }

        else -> if (day == 60 * 60 * 24 * 3) {
            println("был(а) позавчера")
        } else {
            println("был(а) давно")
        }
    }

}
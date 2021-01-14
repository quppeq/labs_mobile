package com.example.labs
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.labs.TimeBF
import java.time.LocalDate
import java.time.LocalDateTime

val studentsStr = "Бортнік Василь - ІВ-72; Чередніченко Владислав - ІВ-73; Гуменюк Олександр - ІВ-71; Корнійчук Ольга - ІВ-71; Киба Олег - ІВ-72; Капінус Артем - ІВ-73; Овчарова Юстіна - ІВ-72; Науменко Павло - ІВ-73; Трудов Антон - ІВ-71; Музика Олександр - ІВ-71; Давиденко Костянтин - ІВ-73; Андрющенко Данило - ІВ-71; Тимко Андрій - ІВ-72; Феофанов Іван - ІВ-71; Гончар Юрій - ІВ-73"
// Task 1
// Create dictionary:
// - key is a group name
// - value is sorted array with students

val students: List<String> = studentsStr.split("; ")
val studentsDict = students
        .map { it.split(" - ")[0] to it.split(" - ")[1] }
        .toMap()

@RequiresApi(Build.VERSION_CODES.O)
val dates : List<TimeBF> = listOf(
        TimeBF(),
        TimeBF(25, 22, 22) - TimeBF(28, 22, 22),
        TimeBF(LocalDateTime.now())
)
val datesList = dates
        .map { it.toString() }
        .toList()


fun Lab2(): Map<String, String> {
    return studentsDict
}

fun Lab2_2(): List<String> {
    return datesList
}

fun mapToString(map: Map<String, String>){

}
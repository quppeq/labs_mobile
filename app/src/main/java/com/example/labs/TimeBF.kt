package com.example.labs
import android.annotation.SuppressLint
import java.time.LocalDateTime
import kotlin.math.sign

fun validator(number: Int, from: Int, to: Int): Boolean {
    return (number >= from) and (number <= to)
}

class TimeBF {
    val sec: Int
    val min: Int
    val hour: Int


    constructor(sec: Int, min: Int, hour: Int) {
        if (validator(sec, 0, 59) and
                validator(min, 0, 59) and
                validator(hour, 0, 23)) {
            this.sec = sec
            this.min = min
            this.hour = hour
        } else {
            this.sec = sec
            this.min = min
            this.hour = hour
        }
    }
    constructor() {
        this.sec = 0
        this.min = 0
        this.hour = 0
    }
    @SuppressLint("NewApi")
    constructor(date: LocalDateTime) {
        this.sec = date.second
        this.min = date.minute
        this.hour = date.hour
    }

    override fun toString(): String {
        return "<hour ${this.hour}, min ${this.min}, sec ${this.sec}>"
    }

    operator fun plus(el: TimeBF): TimeBF {
        val sec = el.sec + this.sec
        val min = el.min + this.min
        val hour = el.hour + this.hour

        return TimeBF(
                sec % 60,
                (min + sec / 60) % 60,
                (hour + (min + sec / 60)) % 24
        )
    }

    operator fun minus(el: TimeBF): TimeBF {
        val sec = this.sec - el.sec
        val min = this.min - el.min
        val hour = this.hour - el.hour
        return TimeBF(
                sec + sec.sign.and(-1)*(-60),
                (min + sec.sign.and(-1)) +
                        (min + sec.sign.and(-1)).sign.and(-1)*(-60),
                (hour + (min + sec.sign.and(-1)).sign.and(-1)) +
                        (hour + (min + sec.sign.and(-1)).sign.and(-1)).sign.and(-1) * (-24)
        )
    }

//    Static Methods
    companion object {
        fun plus(el1: TimeBF, el2: TimeBF): TimeBF {
            val sec = el1.sec + el2.sec
            val min = el1.min + el2.min
            val hour = el1.hour + el2.hour
    
            return TimeBF(
                    sec % 60,
                    (min + sec / 60) % 60,
                    (hour + (min + sec / 60)) % 24
            )
        }

        fun minus(el1: TimeBF, el2: TimeBF): TimeBF {
            val sec = el1.sec - el2.sec
            val min = el1.min - el2.min
            val hour = el1.hour - el2.hour
            return TimeBF(
                    sec + sec.sign.and(-1)*(-60),
                    (min + sec.sign.and(-1)) +
                            (min + sec.sign.and(-1)).sign.and(-1)*(-60),
                    (hour + (min + sec.sign.and(-1)).sign.and(-1)) +
                            (hour + (min + sec.sign.and(-1)).sign.and(-1)).sign.and(-1) * (-24)
            )
        }
    }
}
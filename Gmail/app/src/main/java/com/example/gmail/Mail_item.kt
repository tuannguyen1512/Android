package com.example.gmail

import java.time.LocalTime

data class Mail_item(val title:String, val context:String, val receiver:String,
                     val time: LocalTime, val imageThumb: Int, val imageLarge: Int = 0) {
    var selected: Boolean = false
}
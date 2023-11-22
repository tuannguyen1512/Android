package com.example.gmail

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<Mail_item>()
        repeat(times = 10){items.add(
            Mail_item(
                "Group 1 @ Hàng tuần từ 4PM đến 6PM vào thứ hai (ICT) (cuong@gmail.com)",
                "Xin chào, Trần Mạnh Cường\n" +
                        "Rất hận hạnh được gặp bạn" ,
                receiver = "Google.com",
                LocalTime.now(),
                resources.getIdentifier("avatar", "drawable", packageName)
            )
        )}

        
        findViewById<ListView>(R.id.MailContent).adapter = GmailAdapter(items)


    }
}



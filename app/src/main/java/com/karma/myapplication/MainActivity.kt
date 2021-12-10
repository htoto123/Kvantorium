package com.karma.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val client = HttpClient(CIO) {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.IO) {
            val post = client.post<registartion>("https://api.m3o.com/v1/user/Create") {
                headers {
                    append("Authorization: Bearer", "ZjI2NTU5YjctYWU0Zi00YmM4LTg2MTItYjE1ODE5MTJmOTM2")
                }
                val count = "1"
                body = registartion(
                    email = readLine(),
                    id = count,
                    password = readLine(),
                    username = readLine()
                )
          }
            Log.d ("Registration", "$post")
        }
    }
}
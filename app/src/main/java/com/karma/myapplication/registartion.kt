package com.karma.myapplication
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class registartion(
    @SerialName("email")
    val email: String? = "",
    @SerialName("id")
    val id: String? = "",
    @SerialName("password")
    val password: String? = "",
    @SerialName("username")
    val username: String? = ""
)

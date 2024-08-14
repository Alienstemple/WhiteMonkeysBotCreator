package com.whitemonkeys.botcreator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
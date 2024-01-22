package com.prasanth.kmmjsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
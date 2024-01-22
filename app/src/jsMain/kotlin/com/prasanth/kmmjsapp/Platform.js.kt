package com.prasanth.kmmjsapp
class JsPlatform :Platform{
    override val name: String
        get() = "web"

}
actual fun getPlatform(): Platform = JsPlatform()
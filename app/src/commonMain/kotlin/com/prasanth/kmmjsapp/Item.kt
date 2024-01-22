package com.prasanth.kmmjsapp

import kotlinx.serialization.Serializable

@Serializable
data class Item (val id:String,val name:String,val price:Double)
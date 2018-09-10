package com.shardbytes.shardnote

class Database private constructor() {
    
    private val instance = Database()
    fun getInstance() = instance
    
    val text = "BOI"
    
}
package com.kiro.hm1_m6

interface Clickable {
    fun onClick()
    fun delete()
    fun edit()
    fun choose()
    open fun setupObserver() {}

}
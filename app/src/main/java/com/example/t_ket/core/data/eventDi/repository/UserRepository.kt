package com.example.t_ket.core.data.eventDi.repository

interface UserRepository {

    suspend fun checkIsStaff(staffCode:String): Boolean

    fun setUser( staffCode:String)

    fun getIdEvent(): String
}
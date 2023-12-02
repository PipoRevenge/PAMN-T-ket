package com.example.t_ket.data.userDi.repository

interface UserRepository {
    suspend fun checkIsStaff(id_event:String, staffCode:String): Boolean

    fun setUser(id_event: String, staffCode:String)

    fun getIdEvent(): String
}
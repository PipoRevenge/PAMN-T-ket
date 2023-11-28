package com.example.t_ket.core.data.pipo_chinese.users.repository.remote
//Aqui es la interfaz de las funciones del Impl
interface UserRepository {
    suspend fun checkIsStaff(id_event:String, staffCode:String): Boolean

    fun setUser(id_event: String, staffCode:String)

    fun getIdEvent(): String
}
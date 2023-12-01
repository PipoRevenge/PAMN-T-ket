package com.example.t_ket.core.data.pipo_chinese.users.repository

import com.example.t_ket.core.domain.model.User
import com.example.t_ket.core.data.pipo_chinese.users.repository.remote.UserRemote
import com.example.t_ket.core.data.pipo_chinese.users.repository.remote.UserRemoteImpl

//Aqui van las funciones en si que interactua con la base de datos mediante interactor
class UserRepositoryImpl : UserRepository {
    var user : User? = null
    private val userRemote: UserRemote =  UserRemoteImpl()
    override suspend fun checkIsStaff(EventId: String, StaffCode: String): Boolean {
        return userRemote.isStaff(EventId, StaffCode)
    }

    override fun setUser(id_event: String, staffCode: String) {
        user=
        User(
            codeOfEvent =  id_event,
            codeOfStaff = staffCode
        )
    }

    override fun getIdEvent(): String {
        return user?.codeOfEvent ?: ""
    }
}
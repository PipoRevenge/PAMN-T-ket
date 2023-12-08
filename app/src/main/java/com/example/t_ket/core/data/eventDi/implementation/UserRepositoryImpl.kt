package com.example.t_ket.core.data.eventDi.implementation

import com.example.t_ket.core.domain.model.User
import com.example.t_ket.core.data.eventDi.remote.repository.UserRemote
import com.example.t_ket.core.data.eventDi.remote.implementation.UserFirebaseImpl
import com.example.t_ket.core.data.eventDi.repository.UserRepository

//Aqui van las funciones en si que interactua con la base de datos mediante interactor
class UserRepositoryImpl (idEvent: String) : UserRepository {
    private val ref = idEvent
    private var user : User? = null
    private val userRemote: UserRemote =  UserFirebaseImpl()
    override suspend fun checkIsStaff(staffCode: String): Boolean {
        return userRemote.isStaff(ref, staffCode)
    }

    override fun setUser(staffCode: String) {
        user=
        User(
            codeOfEvent =  ref,
            codeOfStaff = staffCode
        )
    }

    override fun getIdEvent(): String {
        return user?.codeOfEvent ?: ""
    }
}
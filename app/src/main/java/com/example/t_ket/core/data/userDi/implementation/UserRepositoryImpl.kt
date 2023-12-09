package com.example.t_ket.core.data.userDi.implementation


import com.example.t_ket.core.domain.model.User
import com.example.t_ket.core.data.userDi.remote.repository.UserRemote
import com.example.t_ket.core.data.userDi.remote.implementation.UserFirebaseImpl
import com.example.t_ket.core.data.userDi.repository.UserRepository

//Aqui van las funciones en si que interactua con la base de datos mediante interactor
class UserRepositoryImpl : UserRepository {
    var user : User? = null
    private val userRemote: UserRemote =  UserFirebaseImpl()
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
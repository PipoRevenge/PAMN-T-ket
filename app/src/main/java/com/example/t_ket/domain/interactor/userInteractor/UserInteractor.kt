package com.example.t_ket.domain.interactor.userInteractor

interface UserInteractor {

    fun asociateUser(codigo: String): Boolean

    fun userEvent(evento: String): Boolean

    fun userCode(codigo: String): Boolean

}
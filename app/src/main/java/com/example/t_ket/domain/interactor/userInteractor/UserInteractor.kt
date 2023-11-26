package com.example.t_ket.domain.interactor.userInteractor

interface UserInteractor {

    suspend fun asociateUser(codigo: String, function: () -> Unit): Boolean

}
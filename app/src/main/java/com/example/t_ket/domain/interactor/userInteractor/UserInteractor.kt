package com.example.t_ket.domain.interactor.userInteractor

interface UserInteractor {
    suspend fun associateUser(codigo: String): Boolean
}
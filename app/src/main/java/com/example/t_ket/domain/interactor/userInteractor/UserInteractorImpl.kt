package com.example.t_ket.domain.interactor.userInteractor
import  com.example.t_ket.data.users.repository.UserRepository
import  com.example.t_ket.data.users.repository.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserInteractorImpl(private val userInteractor: UserInteractor) : UserInteractor {

    private val userRepository : UserRepository = UserRepositoryImpl()
     override suspend fun asociateUser(codigo: String): Boolean{
        return userRepository.checkIsStaff(codigo.substring(0,3),codigo.substring(4,7))
    }
}
package com.example.t_ket.domain.interactor.userInteractor
import  com.example.t_ket.data.users.repository.UserRepository
import  com.example.t_ket.data.users.repository.UserRepositoryImpl

class UserInteractorImpl(private val userInteractor: UserInteractor) : UserInteractor {

     private val userRepository : UserRepository = UserRepositoryImpl()
     override suspend fun associateUser(codigo: String): Boolean{
        return userRepository.checkIsStaff(codigo.substring(0,3),codigo.substring(4,7))
    }
}
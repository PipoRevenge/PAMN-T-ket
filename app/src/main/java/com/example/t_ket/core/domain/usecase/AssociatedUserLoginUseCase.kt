package com.example.t_ket.core.domain.usecase
import  com.example.t_ket.core.data.pipo_chinese.users.repository.UserRepository
import  com.example.t_ket.core.data.pipo_chinese.users.repository.UserRepositoryImpl
import com.example.t_ket.core.domain.repository.UserUseCaseRepository

class AssociatedUserLoginUseCase() : UserUseCaseRepository {
     private val userRepository : UserRepository = UserRepositoryImpl()
     override suspend fun associateUser(codigo: String): Boolean{
        return userRepository.checkIsStaff(codigo.substring(0,3),codigo)
    }
}
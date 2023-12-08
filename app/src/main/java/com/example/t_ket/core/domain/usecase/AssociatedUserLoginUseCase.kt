package com.example.t_ket.core.domain.usecase

import android.util.Log
import com.example.t_ket.core.data.eventDi.implementation.EventImpl
import  com.example.t_ket.core.data.eventDi.repository.UserRepository
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject



class AssociatedUserLoginUseCase @Inject constructor(private val eventRepository: EventRepository) : UserUseCaseRepository {

    override suspend fun associateUser(codigo: String): Boolean{
        if(codigo == ""){
            return false
        }
        val code = codigo.substring(0,3)
        eventRepository.initEvent(code)
        val userRepository =eventRepository.getUserRepository()
        return userRepository.checkIsStaff(codigo)


    }
}

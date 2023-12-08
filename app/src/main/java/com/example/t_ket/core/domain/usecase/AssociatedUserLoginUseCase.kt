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
        //Arreglar el codigo
        Log.d("Mio2","Voy a entrar")
        Log.d("Mio2",codigo)
        eventRepository.initEvent(codigo)
        Log.d("Mio2","Sali")

        return eventRepository.getUserRepository().checkIsStaff(codigo)

        //Log.d("Pipo", eventRepository.getEventInfo().toString())

    }
}

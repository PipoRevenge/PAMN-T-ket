package com.example.t_ket.core.domain.usecase;
import android.util.Log
import com.example.t_ket.core.domain.model.Ticket

import com.example.t_ket.core.data.eventDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.data.eventDi.repository.TicketRepository


import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import javax.inject.Inject

//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

public class TicketInteractorImpl @Inject constructor(public val eventRepository: EventRepository) : TicketUseCaseRepository {
    private val ticketRepository : TicketRepository =  eventRepository.getTicketRepository()

    override fun getAllTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getTicketById(): Ticket {
        TODO("Not yet implemented")
    }

    override suspend fun checkTicket(ticketInfo: String): Boolean? {
        val id_ticket = "" // String
        val regex = "\"([^\"]*)\"".toRegex()
        val matchResults = regex.findAll(ticketInfo)
        if (matchResults != null) {
            for ((index, matchResult) in matchResults.withIndex()) {
                // El índice 0 generalmente es la coincidencia completa, el índice 1 es el primer grupo de captura, y así sucesivamente.
                val value = matchResult.groupValues[1]
                // Imprimir solo el valor del segundo match
                if (index == 1) {
                    Log.d("AAAAAAAAAAAAAAAAA", "$value")
                    ticketRepository.updateStatusTicket(value, true)
                }
            }
            return true
        } else {
            return false
        }
    }
    override fun getNotValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }
    override fun getValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getGroupTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

}

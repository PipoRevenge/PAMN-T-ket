package com.example.t_ket.core.domain.usecase;
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
        val id_ticket = "" // String o JSON con un campo
        val ticket = ticketRepository.getTicketById(id_ticket)
        if( ticket != null){
            if(ticket.status == false){
                ticketRepository.updateStatusTicket(id_ticket,true)
                return true
            }
            return null
        }
        return false

    }

    override fun getValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getNotValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getGroupTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

}

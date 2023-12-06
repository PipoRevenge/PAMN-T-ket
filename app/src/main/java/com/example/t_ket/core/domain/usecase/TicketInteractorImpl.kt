package com.example.t_ket.core.domain.usecase;
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.ticketDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.ticketDi.repository.TicketRepository
import com.example.t_ket.core.data.userDi.repository.UserRepository
import com.example.t_ket.core.data.userDi.implementation.UserRepositoryImpl

import com.example.t_ket.core.domain.repository.TicketUseCaseRepository

//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

public class TicketInteractorImpl: TicketUseCaseRepository {
    private val ticketRepository : TicketRepository = TicketRepositoryImpl()

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

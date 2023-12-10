package com.example.t_ket.core.domain.usecase;
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.data.eventDi.repository.TicketRepository

import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import org.json.JSONObject
import javax.inject.Inject

//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

class TicketInteractorImpl @Inject constructor(public val eventRepository: EventRepository) : TicketUseCaseRepository {
    private val ticketRepository : TicketRepository =  eventRepository.getTicketRepository()

    override fun getAllTickets(): List<Ticket> {

        return ticketRepository.getAllTickets().values.toList()
    }

    override suspend fun getTicketById(idTicket: String): Ticket? {
       return ticketRepository.getTicketById(idTicket)
    }

    override suspend fun checkTicketQr(ticketInfo: String): Boolean? {
        //Que pasa si esta en grupo
        val jsonObject = JSONObject(ticketInfo)
        val id_ticket = jsonObject.getString("id")
        return checkTicketById(id_ticket)

    }
    override suspend fun checkTicketById(id_ticket: String): Boolean? {
        //Que pasa si esta en grupo

        val ticket = ticketRepository.getTicketById(id_ticket)
        if( ticket != null){
            if(ticket.idGroup !=""){
                val listTickets =ticketRepository.getTicketsFromGroup(ticket.idGroup)
                for (ticket2: Ticket in listTickets) {
                    ticketRepository.updateStatusTicket(ticket2.id,true)
                }
                return true
            }
            else if(ticket.status == false){
                ticketRepository.updateStatusTicket(id_ticket,true)
                return true
            }
            return null
        }
        return false

    }

    override suspend fun getValidatedTickets(): List<Ticket> {
        return ticketRepository.getValidatedTickets()
    }

    override suspend fun getNotValidatedTickets(): List<Ticket> {
        return ticketRepository.getInvalidatedTickets()
    }

    override suspend fun getGroupTickets(idGrop:String): List<Ticket> {
        return ticketRepository.getTicketsFromGroup(idGrop)
    }

}

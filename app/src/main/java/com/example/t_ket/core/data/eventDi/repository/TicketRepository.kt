package com.example.t_ket.core.data.eventDi.repository

import com.example.t_ket.core.domain.model.Ticket

interface TicketRepository {
    suspend fun setIdEvent()
    fun getAllTickets(): MutableMap<String, Ticket>
    suspend fun getTicketById(id_ticket:String) : Ticket?
    suspend fun getTicketsFromGroup(id_group: String ) : List<Ticket>
    suspend fun getTicketByDni(dni_ticket:String) : Ticket?
    suspend fun updateStatusTicket(id_ticket: String, status:Boolean)
    suspend fun getValidatedTickets() : List<Ticket>;
    suspend fun getNonValidatedTickets() : List<Ticket>;
    suspend fun getInvalidatedTickets() : List<Ticket>;


}
interface TicketUpdateListener {
    fun onTicketsUpdated(newTickets: Map<String, Ticket>)
}
package com.example.t_ket.core.data.ticketDi.repository

import com.example.t_ket.core.domain.model.Ticket

interface TicketRepository {

    suspend fun updateStatusTicket(id_ticket: String, status:Boolean)



}
interface TicketUpdateListener {
    fun onTicketsUpdated(newTickets: Map<String, Ticket>)
}
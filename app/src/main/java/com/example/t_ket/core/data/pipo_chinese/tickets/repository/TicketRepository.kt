package com.example.t_ket.core.data.pipo_chinese.tickets.repository

import com.example.t_ket.core.domain.model.Ticket


interface TicketRepository {
    fun startListeningToTickets(id_event: String)

    fun getTicketById(id:String): Ticket?
    fun updateTicketStatus(id_event:String,id: String, status: Boolean): Boolean
    fun printTickets()
}
interface TicketUpdateListener {
    fun onTicketsUpdated(newTickets: Map<String, Ticket>)
}


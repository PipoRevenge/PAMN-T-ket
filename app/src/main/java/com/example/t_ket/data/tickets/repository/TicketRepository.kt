package com.example.t_ket.data.tickets.repository

import com.example.t_ket.data.tickets.model.Ticket


interface TicketRepository {
    fun startListeningToTickets(id_event: String)

    fun getTicketById(id:String): Ticket?
    fun updateTicketStatus(id_event:String,id: String, status: Boolean): Boolean
    fun printTickets()
}
interface TicketUpdateListener {
    fun onTicketsUpdated(newTickets: Map<String, Ticket>)
}


package com.example.t_ket.core.data.pipo_chinese.tickets.repository

import android.util.Log
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.pipo_chinese.tickets.repository.remote.TicketRemote
import com.example.t_ket.core.data.pipo_chinese.tickets.repository.remote.TicketRemoteImpl


class TicketRepositoryImpl : TicketRepository, TicketUpdateListener {

    private val ticketRemote: TicketRemote = TicketRemoteImpl(this)
    private val tickets = mutableMapOf<String, Ticket>()
    override fun getTicketById( id: String): Ticket? {
        return tickets.get(id)
    }

    override fun printTickets() {
        tickets?.forEach { (id, ticket) ->
            Log.d("TAG" ,"Me cago en todo")
            Log.d("TAG" ,"Ticket ID: $id, Status: ${ticket.status}, idGropu: ${ticket.idGroup}")
        }
    }
    override fun startListeningToTickets(id_event: String) {
        ticketRemote.getTicketsFromFirebase(id_event)
    }

    override fun updateTicketStatus(id_event:String, id: String, status: Boolean): Boolean {
        tickets[id]?.status = status
        return ticketRemote.updateTicketStatusInFirebase(id_event,id, status)
    }

    override fun onTicketsUpdated(newTickets: Map<String, Ticket>) {
        tickets.putAll(newTickets)
    }
}
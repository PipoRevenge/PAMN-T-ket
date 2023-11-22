package com.example.t_ket.data.tickets.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.t_ket.data.tickets.model.Ticket
import com.example.t_ket.data.tickets.repository.remote.TicketRemote
import com.example.t_ket.data.tickets.repository.remote.TicketRemoteImpl
import com.google.firebase.database.core.Tag

class TicketRepositoryImpl : TicketRepository, TicketUpdateListener {

    private val ticketRemote: TicketRemote = TicketRemoteImpl(this)
    private val tickets = mutableMapOf<String, Ticket>()
    override fun getTicketById( id: String): Ticket? {
        return tickets.get(id)
    }

    override fun printTickets() {
        tickets?.forEach { (id, ticket) ->
            Log.d("TAG" ,"Me cago en todo")
            Log.d("TAG" ,"Ticket ID: $id, Status: ${ticket.status}")
        }
    }
    override fun startListeningToTickets(id_event: String) {
        ticketRemote.getTicketsFromFirebase(id_event)
    }

    override fun updateTicketStatus(id_event:String, id: String, status: Boolean) {
        tickets[id]?.status = status
        ticketRemote.updateTicketStatusInFirebase(id_event,id, status)
    }

    override fun onTicketsUpdated(newTickets: Map<String, Ticket>) {
        tickets.putAll(newTickets)
    }
}
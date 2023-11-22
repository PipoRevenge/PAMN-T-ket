package com.example.t_ket.data.tickets.repository.remote
import com.example.t_ket.data.tickets.model.Ticket

interface TicketRemote {
    fun getTicketsFromFirebase(id_event: String)
    fun updateTicketStatusInFirebase(id_event:String, id: String, status: Boolean)
}
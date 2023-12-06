package com.example.t_ket.core.data.pipo_chinese.tickets.repository.remote

interface TicketRemote {
    fun getTicketsFromFirebase(id_event: String)
    fun updateTicketStatusInFirebase(id_event:String, id: String, status: Boolean): Boolean
}
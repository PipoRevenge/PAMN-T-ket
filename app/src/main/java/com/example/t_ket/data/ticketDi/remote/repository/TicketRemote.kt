package com.example.t_ket.data.ticketDi.remote.repository

import com.example.t_ket.core.domain.model.Ticket

interface TicketRemote {
    suspend fun setIdEvent(id_event: String): Boolean
    suspend fun getTicketById(id_ticket: String): Ticket?
    suspend fun getTicketsFromGroup(id_group: String): List<Ticket>
    suspend fun getTicketByDni(dni_ticket: String): Ticket?
    suspend fun updateStatusTicket(id_ticket: String, status: Boolean)
    fun getTicketsFromFirebase(): Map<String, Ticket>
    suspend fun updateTicketStatusInFirebase(id: String, status: Boolean): Boolean
    suspend fun getTicketsByStatus(validation: Boolean?): List<Ticket>
}
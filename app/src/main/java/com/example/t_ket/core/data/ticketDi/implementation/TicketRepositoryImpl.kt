package com.example.t_ket.core.data.ticketDi.implementation

import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.ticketDi.remote.implementation.TicketFirebaseImpl
import com.example.t_ket.core.data.ticketDi.remote.repository.TicketRemote
import com.example.t_ket.core.data.ticketDi.repository.TicketRepository
import com.example.t_ket.core.data.ticketDi.repository.TicketUpdateListener

class TicketRepositoryImpl() : TicketRepository, TicketUpdateListener {
    private val remote: TicketRemote = TicketFirebaseImpl(this)
    private val tickets = mutableMapOf<String, Ticket>()
    override suspend fun setIdEvent(id_event: String) {
        remote.setIdEvent(id_event)
        tickets.putAll(remote.getTicketsFromFirebase())
        // Aquí deberías también establecer el id del evento en tu fuente de datos local
    }

    override fun getAllTickets(): MutableMap<String, Ticket> {

        return tickets
        // Aquí deberías también obtener todos los tickets de tu fuente de datos local
    }

    override suspend fun getTicketById(id_ticket: String): Ticket? {
        return remote.getTicketById(id_ticket)
        // Aquí deberías también obtener el ticket por id de tu fuente de datos local
    }

    override suspend fun getTicketsFromGroup(id_group: String): List<Ticket> {
        return remote.getTicketsFromGroup(id_group)
        // Aquí deberías también obtener los tickets de un grupo de tu fuente de datos local
    }

    override suspend fun getTicketByDni(dni_ticket: String): Ticket? {
        return remote.getTicketByDni(dni_ticket)
        // Aquí deberías también obtener el ticket por DNI de tu fuente de datos local
    }

    override suspend fun updateStatusTicket(id_ticket: String, status: Boolean) {
        remote.updateStatusTicket(id_ticket, status)
        // Aquí deberías también actualizar el estado del ticket en tu fuente de datos local
    }
    override fun onTicketsUpdated(newTickets: Map<String, Ticket>) {
        tickets.putAll(newTickets)
    }

    override suspend fun getValidatedTickets(): List<Ticket> {
        return remote.getTicketsByStatus(true)
    }

    override suspend fun getNonValidatedTickets(): List<Ticket> {

        return remote.getTicketsByStatus(null)
    }

    override suspend fun getInvalidatedTickets(): List<Ticket> {
        return remote.getTicketsByStatus(true)
    }
}


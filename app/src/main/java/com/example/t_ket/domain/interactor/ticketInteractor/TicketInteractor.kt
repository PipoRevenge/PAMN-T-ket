package com.example.t_ket.domain.interactor.ticketInteractor;

import com.example.t_ket.data.tickets.model.Ticket

//Interfaz para Imple
public interface TicketInteractor {
    //Lista completa de ticket
    fun getAllTickets(): List<Ticket>
    //Validar ticket
    suspend fun checkTicket(ticket: Ticket): Boolean


}

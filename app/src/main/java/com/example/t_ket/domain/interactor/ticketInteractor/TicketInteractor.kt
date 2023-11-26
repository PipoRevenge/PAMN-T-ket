package com.example.t_ket.domain.interactor.ticketInteractor;

import com.example.t_ket.data.tickets.model.Ticket

//Interfaz para Imple
public interface TicketInteractor {
    //Lista completa de ticket
    fun getAllTickets(): List<Ticket>
    //Filtrar en presenter ^^^^^^^ o implementar un caso por cada situacion
    fun getValidatedTickets(): List<Ticket>
    fun getNotValidatedTickets(): List<Ticket>
    fun getGroupTickets(): List<Ticket>


    //Validar ticket
    suspend fun checkTicket(id_ticket: String): Boolean

    fun getTicketById(): Ticket


}

package com.example.t_ket.core.domain.repository;

import com.example.t_ket.core.domain.model.Ticket

//Interfaz para Imple
public interface TicketUseCaseRepository {
    //Lista completa de ticket
    fun getAllTickets(): List<Ticket>
    //Filtrar en presenter ^^^^^^^ o implementar un caso por cada situacion
    fun getValidatedTickets(): List<Ticket>
    fun getNotValidatedTickets(): List<Ticket>
    fun getGroupTickets(): List<Ticket>


    //Validar ticket
    suspend fun checkTicket(ticketInfo: String):Boolean?

    fun getTicketById(): Ticket


}

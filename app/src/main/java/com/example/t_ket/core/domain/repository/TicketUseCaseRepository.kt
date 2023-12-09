package com.example.t_ket.core.domain.repository;

import com.example.t_ket.core.domain.model.Ticket

//Interfaz para Imple
public interface TicketUseCaseRepository {
    //Lista completa de ticket
    fun getAllTickets(): List<Ticket>
    //Filtrar en presenter ^^^^^^^ o implementar un caso por cada situacion
    suspend fun getValidatedTickets(): List<Ticket>
    suspend fun getNotValidatedTickets(): List<Ticket>

    //Validar ticket
    suspend fun checkTicket(ticketInfo: String):Boolean?
    suspend fun getTicketById(idTicket: String): Ticket?
    suspend fun getGroupTickets(idGrop: String): List<Ticket>
}

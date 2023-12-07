package com.example.t_ket.core.domain.usecase;
import android.util.Log
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.ticketDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.ticketDi.repository.TicketRepository
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.t_ket.core.data.userDi.repository.UserRepository
import com.example.t_ket.core.data.userDi.implementation.UserRepositoryImpl

import com.example.t_ket.core.domain.repository.TicketUseCaseRepository

//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

public class TicketInteractorImpl: TicketUseCaseRepository {
    private val ticketRepository : TicketRepository = TicketRepositoryImpl()

    override fun getAllTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getTicketById(): Ticket {
        TODO("Not yet implemented")
    }

    override suspend fun checkTicket(ticketInfo: String): Boolean? {
        val id_ticket = "" // String
        val regex = "\"([^\"]*)\"".toRegex()
        val matchResults = regex.findAll(ticketInfo)
        if (matchResults != null) {
            for ((index, matchResult) in matchResults.withIndex()) {
                // El índice 0 generalmente es la coincidencia completa, el índice 1 es el primer grupo de captura, y así sucesivamente.
                val value = matchResult.groupValues[1]
                // Imprimir solo el valor del segundo match
                if (index == 1) {
                    Log.d("AAAAAAAAAAAAAAAAA", "$value")
                }
            }
            return true
        } else {
            return false
        }
    }
    override fun getNotValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }
    override fun getValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getGroupTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

}

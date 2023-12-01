package com.example.t_ket.core.domain.usecase;
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.pipo_chinese.tickets.repository.TicketRepository;
import com.example.t_ket.core.data.pipo_chinese.tickets.repository.TicketRepositoryImpl;
import com.example.t_ket.core.data.pipo_chinese.users.repository.UserRepository
import com.example.t_ket.core.data.pipo_chinese.users.repository.UserRepositoryImpl
import com.example.t_ket.core.domain.repository.TicketUseCaseRepository

//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

public class TicketInteractorImpl: TicketUseCaseRepository {
    private val ticketRepository : TicketRepository = TicketRepositoryImpl()
    private val userRepository : UserRepository = UserRepositoryImpl()
    override fun getAllTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getTicketById(): Ticket {
        TODO("Not yet implemented")
    }

    override suspend fun checkTicket(id_ticket: String): Boolean {
        val codeEvent = userRepository.getIdEvent()
        if(codeEvent == ""){
            return false
        }
        return ticketRepository.updateTicketStatus(codeEvent,id_ticket,status = true)
    }

    override fun getValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getNotValidatedTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getGroupTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

}

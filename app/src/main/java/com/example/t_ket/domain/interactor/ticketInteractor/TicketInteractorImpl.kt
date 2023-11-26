package com.example.t_ket.domain.interactor.ticketInteractor;
import com.example.t_ket.data.tickets.model.Ticket
import com.example.t_ket.data.tickets.repository.TicketRepository;
import com.example.t_ket.data.tickets.repository.TicketRepositoryImpl;
import com.example.t_ket.data.users.repository.UserRepository
import com.example.t_ket.data.users.repository.UserRepositoryImpl

//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

public class TicketInteractorImpl: TicketInteractor {
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

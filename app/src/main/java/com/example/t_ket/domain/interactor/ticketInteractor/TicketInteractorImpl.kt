package com.example.t_ket.domain.interactor.ticketInteractor;
import com.example.t_ket.data.tickets.model.Ticket
import com.example.t_ket.data.tickets.repository.TicketRepository;
import com.example.t_ket.data.tickets.repository.TicketRepositoryImpl;
//Aqui va las propias interacciones con el modelo en cuestion usando el repositorio para los datos

public class TicketInteractorImpl(private val ticketInteractor: TicketInteractor) : TicketInteractor {
    private val ticketRepository : TicketRepository = TicketRepositoryImpl()
    override fun getAllTickets(): List<Ticket> {
        TODO("Not yet implemented")
    }

    override fun getTicketById(): Ticket {
        TODO("Not yet implemented")
    }

    override suspend fun checkTicket(ticket: Ticket): Boolean {
        //return ticketRepository.updateTicketStatus()
        TODO("Not yet implemented")
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

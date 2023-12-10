package com.example.t_ket.core.domain.usecase

import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import javax.inject.Inject

class EventInfoGetter @Inject constructor(public val eventRepository: EventRepository) {
     suspend fun getEventInfo(): Event? {
         return eventRepository.getEventInfo()
    }
    suspend fun getNumberOfValidatedTickets(): Int {
        return eventRepository.getTicketRepository().getValidatedTickets().size

    }

    suspend fun getNumberOfNoValidatedTickets(): Int? {
        val numValidated = eventRepository.getTicketRepository().getValidatedTickets().size
        val numNoValidate = eventRepository.getEventInfo()?.capacity?.minus(numValidated)
        return numNoValidate
    }
}
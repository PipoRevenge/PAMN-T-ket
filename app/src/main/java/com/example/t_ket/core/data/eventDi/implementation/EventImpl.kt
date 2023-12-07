package com.example.t_ket.core.data.eventDi.implementation

import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.core.data.eventDi.remote.implementation.EventFirebaseImpl
import com.example.t_ket.core.data.eventDi.repository.TicketRepository
import com.example.t_ket.core.data.eventDi.repository.UserRepository


class EventImpl() : EventRepository  {
    private val remote: EventFirebaseImpl = EventFirebaseImpl()
    private lateinit var ticketRepository: TicketRepository
    private lateinit var userRepository: UserRepository
    private lateinit var  event : Event


    override suspend fun initEvent(idEvent: String) : Boolean{
        if(remote.setIdEvent(idEvent)){
            ticketRepository= TicketRepositoryImpl(idEvent)
            ticketRepository.setIdEvent()
            userRepository = UserRepositoryImpl(idEvent)
            event = this.getEventInfo()!!
        }
        return false

    }



    override suspend fun getEventInfo(): Event? {
        return event
    }

    override fun getTicketRepository(): TicketRepository {
        return this.ticketRepository
    }

    override suspend fun getImageUrl(): String? {
        return event.imageRef?.let { remote.getImageUrl(it) }
    }

    override fun getUserRepository(): UserRepository {
        return userRepository
    }
}
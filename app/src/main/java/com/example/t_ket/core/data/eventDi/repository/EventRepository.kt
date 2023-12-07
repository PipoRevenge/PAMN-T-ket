package com.example.t_ket.core.data.eventDi.repository
import com.example.t_ket.core.domain.model.Event

interface EventRepository {

    suspend fun initEvent(idEvent: String):Boolean
    suspend fun getEventInfo() : Event?
    suspend fun getImageUrl(): String?
    fun getTicketRepository():TicketRepository
    fun getUserRepository():UserRepository

}
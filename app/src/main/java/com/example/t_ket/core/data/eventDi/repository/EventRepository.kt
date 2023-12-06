package com.example.t_ket.core.data.eventDi.repository
import com.example.t_ket.core.domain.model.Event

interface EventRepository {
    suspend fun setEventId(eventId:String)
    suspend fun getEventInfo() : Event?
}
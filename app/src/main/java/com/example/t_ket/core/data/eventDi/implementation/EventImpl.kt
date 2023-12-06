package com.example.t_ket.core.data.eventDi.implementation

import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.core.data.eventDi.remote.EventRemote
import com.example.t_ket.core.data.eventDi.remote.implementation.EventFirebaseImpl


class EventImpl : EventRepository  {
    private val remote: EventFirebaseImpl = EventFirebaseImpl()
    var eventId = ""
    override suspend fun setEventId(eventId: String) {
        this.eventId = eventId
    }

    override suspend fun getEventInfo(): Event? {
        return remote.getEventInfo(this.eventId)
    }
}
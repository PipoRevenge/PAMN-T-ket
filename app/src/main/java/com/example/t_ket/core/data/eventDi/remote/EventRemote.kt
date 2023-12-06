package com.example.t_ket.core.data.eventDi.remote

import com.example.t_ket.core.domain.model.Event

interface EventRemote {
    suspend fun getEventInfo(eventId : String): Event?
}
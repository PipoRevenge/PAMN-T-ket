package com.example.t_ket.core.data.eventDi.remote.implementation

import com.example.t_ket.core.data.eventDi.remote.EventRemote
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.core.domain.model.Ticket
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class EventFirebaseImpl : EventRemote {
    private val firestore = FirebaseFirestore.getInstance()
    override suspend fun getEventInfo(eventId : String): Event? {

        val document = firestore.collection("Events").document(eventId).get()?.await()

        if (document != null) {
            val data = document.data
             val eventInfo = Event(
                 capacity = (data?.get("capacity") as? Long)?.toInt() ?:0,
                 date = data?.get("date") as String,
                 description = data?.get("description") as String ,
                 end_time = data?.get("end_time") as String,
                 location = data?.get("location") as String,
                 name = data?.get("name") as String,
                 organizer = data?.get("organizer") as String,
                 start_time = data?.get("start_time") as String,

            )
            return eventInfo
        }
        return null

    }
}
package com.example.t_ket.core.data.eventDi.remote.implementation

import android.util.Log
import com.example.t_ket.core.data.AppData
import com.example.t_ket.core.data.eventDi.remote.repository.EventRemote
import com.example.t_ket.core.domain.model.Event
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class EventFirebaseImpl : EventRemote {
    val db = FirebaseFirestore.getInstance()

    override suspend fun getEventInfo() : Event {
        val eventInfo = Event()
        val docRef = db.collection("Events").document(AppData.event).get()?.await()
        if (docRef != null) {
            eventInfo.capacity = docRef.getLong("Capacity")?.toInt()
            eventInfo.name = docRef.getString("Name")
            eventInfo.end_time = docRef.getString("EndTime")
            eventInfo.start_time = docRef.getString("StartTime")
            eventInfo.validatedTickets = 2
            eventInfo.notValidatedTickets = 2
            Log.d("FIREBASE", "$eventInfo")
            Log.d("ZZZZZZZZZ", "Exito al obtener los datos del evento")
        }
        return eventInfo
    }
    override suspend fun getNumberOfValidatedTickets() : Int {
        TODO("Not yet implemented")
    }
    override suspend fun getNumberOfNotValidatedTickets() : Int {
        TODO("Not yet implemented")
    }
}
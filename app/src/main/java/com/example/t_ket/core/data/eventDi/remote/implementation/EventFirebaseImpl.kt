package com.example.t_ket.core.data.eventDi.remote.implementation

import android.util.Log
import com.example.t_ket.core.data.eventDi.remote.repository.EventRemote
import com.example.t_ket.core.domain.model.Event
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

class EventFirebaseImpl : EventRemote {
    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private lateinit var eventId :String

    override suspend fun setIdEvent(eventId: String): Boolean {
        val document = firestore.collection("Events").document(eventId).get().await()
        if(document.exists()){
            this.eventId = eventId

            return true
        }else{
            return false
        }
    }

    override suspend fun getEventInfo(): Event? {

        val document = firestore.collection("Events").document(eventId).get()?.await()

        if (document != null) {
            val data = document.data
             val eventInfo = Event(
                 capacity = (data?.get("capacity") as? Long)?.toInt() ?:0,
                 end_time = data?.get("end_time") as String,
                 name = data?.get("name") as String,
                 organizer = data?.get("organizer") as String,
                 start_time = data?.get("start_time") as String,
                 imageRef = data?.get("imageRef") as String
            )
            return eventInfo
        }
        return null

    }
    override suspend fun getImageUrl(imageRef: String): String {
        val storageRef = storage.getReferenceFromUrl(imageRef)
        return try {
            storageRef.downloadUrl.await().toString()
        } catch (e: Exception) {
            Log.e("Pipo", "Error al descargar la URL de la imagen", e)
            throw e
        }
    }

}
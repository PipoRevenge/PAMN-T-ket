package com.example.t_ket.core.data.eventDi.remote.implementation

import com.example.t_ket.core.data.eventDi.remote.repository.EventRemote
import com.example.t_ket.core.domain.model.Event
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

class EventFirebaseImpl : EventRemote {
    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private lateinit var eventId :String
    suspend fun exists(eventId: String): Boolean {
        val document = firestore.collection("Events").document(eventId).get().await()
        return document.exists()
    }
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
                 date = data?.get("date") as String,
                 description = data?.get("description") as String ,
                 end_time = data?.get("end_time") as String,
                 location = data?.get("location") as String,
                 name = data?.get("name") as String,
                 organizer = data?.get("organizer") as String,
                 start_time = data?.get("start_time") as String,
                 imageRef = data?.get("imageRef") as String
            )
            return eventInfo
        }
        return null

    }
    suspend fun getImageUrl(imageRef: String): String? {
        val storageRef = storage.getReferenceFromUrl(imageRef)
        var url: String? = null

        storageRef.downloadUrl.addOnSuccessListener { uri ->
            url = uri.toString()
        }.addOnFailureListener {
            // Handle any errors
        }

        return url
    }
}
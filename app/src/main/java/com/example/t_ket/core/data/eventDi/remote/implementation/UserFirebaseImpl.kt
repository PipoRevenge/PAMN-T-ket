package com.example.t_ket.core.data.eventDi.remote.implementation
import com.google.firebase.firestore.FirebaseFirestore
import com.example.t_ket.core.data.eventDi.remote.repository.UserRemote
import kotlinx.coroutines.tasks.await

class UserFirebaseImpl(): UserRemote {
    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun isStaff(EventId:String, StaffCode:String): Boolean {

         val document = firestore.collection("Events").document(EventId).collection("Staff").document(StaffCode).get().await()
         return document.exists()
    }
}
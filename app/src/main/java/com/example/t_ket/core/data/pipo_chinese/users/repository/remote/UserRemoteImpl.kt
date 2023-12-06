package com.example.t_ket.core.data.pipo_chinese.users.repository.remote
import com.google.firebase.firestore.FirebaseFirestore
import com.example.t_ket.core.data.pipo_chinese.users.repository.remote.UserRemote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UserRemoteImpl(): UserRemote {
    private val firestore = FirebaseFirestore.getInstance()

    override suspend fun isStaff(EventId:String, StaffCode:String): Boolean {

         val document = firestore.collection("Events").document(EventId).collection("Staff").document(StaffCode).get().await()
         return document.exists()
    }
}
package com.example.t_ket.core.data.pipo_chinese.tickets.repository.remote
import android.content.ContentValues.TAG
import android.util.Log
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.pipo_chinese.tickets.repository.TicketUpdateListener
import com.google.firebase.firestore.FirebaseFirestore

class TicketRemoteImpl(private val listener: TicketUpdateListener) : TicketRemote {
    private val firestore = FirebaseFirestore.getInstance()
    override fun getTicketsFromFirebase(id_event: String) {
        firestore.collection("Events").document(id_event).collection("Tickets")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.d(TAG, "Error al obtener los tickets desde Firebase: ${e.message}")

                    return@addSnapshotListener
                }

                val tickets = mutableMapOf<String, Ticket>()
                for (document in snapshots!!) {
                    val data = document.data
                    val ticket = Ticket(
                        status = data["status"] as Boolean,
                        fullName = data["fullName"] as String,
                        //dni = data["dni"] as Int,
                        //checkIn = data["checkIn"] as Date?,
                        idGroup = data["idGroup"] as String?
                    )
                    tickets[document.id] = ticket
                }
                listener.onTicketsUpdated(tickets)
            }
    }

    override fun updateTicketStatusInFirebase(id_event:String,id: String, status: Boolean):Boolean {
        try {
            firestore.collection("Events").document(id_event).collection("Tickets").document(id)
                .update("status", status)
            return true
        }catch (e: Exception) {
            Log.d(TAG, "Error al actualizar el estado del ticket en Firebase: ${e.message}")
            return false;
        }

    }
}
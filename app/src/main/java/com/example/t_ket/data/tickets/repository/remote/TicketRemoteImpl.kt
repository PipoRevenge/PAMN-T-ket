package com.example.t_ket.data.tickets.repository.remote
import com.example.t_ket.data.tickets.model.Ticket
import com.example.t_ket.data.tickets.repository.TicketUpdateListener
import com.google.firebase.firestore.FirebaseFirestore

class TicketRemoteImpl(private val listener: TicketUpdateListener) : TicketRemote {
    private val firestore = FirebaseFirestore.getInstance()
    override fun getTicketsFromFirebase(id_event: String) {
        firestore.collection("Events").document(id_event).collection("Tickets")
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    // Log the error
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

    override fun updateTicketStatusInFirebase(id_event:String,id: String, status: Boolean) {
        firestore.collection("Events").document(id_event).collection("Tickets").document(id)
            .update("status", status)
    }
}
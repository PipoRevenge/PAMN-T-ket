package com.example.t_ket.data.ticketDi.remote.implementation

import android.content.ContentValues
import android.util.Log

import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.data.ticketDi.implementation.TicketRepositoryImpl
import com.example.t_ket.data.ticketDi.remote.repository.TicketRemote
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class firebaseImpl(val listener: TicketRepositoryImpl) : TicketRemote {
    private val firestore = FirebaseFirestore.getInstance()
    private var eventRef: CollectionReference? = null

    override suspend fun setIdEvent(id_event: String): Boolean {
        val eventRef = firestore.collection("Events").document(id_event)
        val document = eventRef.get().await()
        if (document.exists()) {
            this.eventRef = eventRef.collection("Tickets")
        } else {
            Log.d(ContentValues.TAG, "El evento con id $id_event no existe")
        }
        return eventRef != null
    }

    override suspend fun getTicketById(id_ticket: String): Ticket? {

        val document = eventRef?.document(id_ticket)?.get()?.await()
        if (document != null) {
            val data = document.data
            return Ticket(
                status = data?.get("status") as Boolean,
                fullName = data["fullName"] as String,
                dni = data["dni"] as String,
                //checkIn = data["checkIn"] as Date?,
                idGroup = data["idGroup"] as String?
            )
        }
        return null
    }

    override suspend fun getTicketsFromGroup(id_group: String): List<Ticket> {
        val tickets = mutableListOf<Ticket>()
        val result = eventRef?.whereEqualTo("idGroup", id_group)?.get()?.await()
        if (result != null) {
            for (document in result) {
                val data = document.data
                val ticket = Ticket(
                    status = data["status"] as Boolean,
                    fullName = data["fullName"] as String,
                    dni = data["dni"] as String,
                    //checkIn = data["checkIn"] as Date?,
                    idGroup = data["idGroup"] as String?
                )
                tickets.add(ticket)
            }
        }
        return tickets
    }

    override suspend fun getTicketByDni(dni_ticket: String): Ticket? {
        val result = eventRef?.whereEqualTo("dni", dni_ticket)?.get()?.await()
        if (result != null) {
            for (document in result) {
                val data = document.data
                val ticket = Ticket(
                    status = data["status"] as Boolean,
                    fullName = data["fullName"] as String,
                    dni = data["dni"] as String,
                    //checkIn = data["checkIn"] as Date?,
                    idGroup = data["idGroup"] as String?
                )
                return ticket
            }
        }
        return null
    }

    override suspend fun updateStatusTicket(id_ticket: String, status: Boolean) {
        val ticketRef = eventRef?.document(id_ticket)
        firestore.runTransaction { transaction ->
            transaction.update(ticketRef!!, "status", status)
        }.await()
    }


    override fun getTicketsFromFirebase() {
        eventRef
            ?.addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.d(ContentValues.TAG, "Error al obtener los tickets desde Firebase: ${e.message}")
                    return@addSnapshotListener
                }

                val tickets = mutableMapOf<String, Ticket>()
                for (document in snapshots!!) {
                    val data = document.data
                    val ticket = Ticket(
                        status = data["status"] as Boolean,
                        fullName = data["fullName"] as String,
                        dni = data["dni"] as String,
                        //checkIn = data["checkIn"] as Date?,
                        idGroup = data["idGroup"] as String?
                    )
                    tickets[document.id] = ticket
                }
                listener.onTicketsUpdated(tickets)
            }
    }

    override suspend fun updateTicketStatusInFirebase(id: String, status: Boolean): Boolean {
        try {
            eventRef?.document(id)?.update("status", status)?.await()
            return true
        } catch (e: Exception) {
            Log.d(ContentValues.TAG, "Error al actualizar el estado del ticket en Firebase: ${e.message}")
            return false
        }
    }
}

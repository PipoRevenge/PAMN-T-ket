package com.example.t_ket.core.data.eventDi.remote.implementation

import android.content.ContentValues
import android.util.Log

import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.data.eventDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.eventDi.remote.repository.TicketRemote
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class TicketFirebaseImpl(val listener: TicketRepositoryImpl) : TicketRemote {
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
    private fun createTicketFromDocument(document: DocumentSnapshot): Ticket {
        val data = document.data
        return Ticket(
            id = document.id,
            status = data?.get("status") as Boolean,
            fullName = data["fullName"] as String,
            dni = data["dni"] as String,
            //checkIn = data["checkIn"] as Date?,
            idGroup = data["idGroup"] as String
        )
    }

    override suspend fun getTicketById(id_ticket: String): Ticket? {

        val document = eventRef?.document(id_ticket)?.get()?.await()
        if (document != null) {
            return createTicketFromDocument(document)
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
                    id = document.id ,
                    status = data["status"] as Boolean,
                    fullName = data["fullName"] as String,
                    dni = data["dni"] as String,
                    //checkIn = data["checkIn"] as Date?,
                    idGroup = data["idGroup"] as String
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
                 return createTicketFromDocument(document)
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


    override fun getTicketsFromFirebase(): Map<String, Ticket> {
        val tickets = mutableMapOf<String, Ticket>()

        eventRef
            ?.get()
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val snapshots = task.result
                    for (document in snapshots!!) {
                        val data = document.data
                        val ticket =createTicketFromDocument(document)
                        tickets[document.id] = ticket
                    }
                    listener.onTicketsUpdated(tickets)
                } else {
                    val exception = task.exception
                    Log.d(ContentValues.TAG, "Error al obtener los tickets desde Firebase: ${exception?.message}")
                }
            }

        return tickets
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

    override suspend fun getTicketsByStatus(validation: Boolean?): List<Ticket> {
        val tickets = mutableListOf<Ticket>()
        val result = eventRef?.whereEqualTo("status", validation)?.get()?.await()
        if (result != null) {
            for (document in result) {
                val data = document.data
                val ticket = createTicketFromDocument(document)
                tickets.add(ticket)
            }
        }
        return tickets
    }
}

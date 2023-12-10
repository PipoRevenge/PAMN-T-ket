package com.example.t_ket.core.data.ticketDi.remote.implementation

import android.util.Log
import com.example.t_ket.core.data.ticketDi.implementation.TicketRepositoryImpl
import com.example.t_ket.core.data.ticketDi.remote.repository.TicketRemote
import com.example.t_ket.core.domain.model.Ticket
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await


class TicketFirebaseImpl(val listener: TicketRepositoryImpl) : TicketRemote {
    private val firestore = FirebaseFirestore.getInstance()
    private var eventRef: CollectionReference? = null


    override suspend fun updateStatusTicket(id_ticket: String, status: Boolean) {
        val value = true
        val data = hashMapOf("status" to true)
        val ticketDocRef = firestore.collection("Tickets").document("Tickets")
        ticketDocRef.update("Tickets.$id_ticket.status", value) // Reemplaza 'array' por el nombre del campo que contiene tu array y '1' por la posición del array que quieres actualizar (recuerda que en Firestore se indexa desde 0)
    }

    override suspend fun getValidatedTickets(): List<Ticket> {
        val ticketsList = mutableListOf<Ticket>()

        return ticketsList
    }


    override suspend fun getNotValidatedTickets(): List<Ticket> {
        val ticketsList = mutableListOf<Ticket>()

        return ticketsList
    }
}

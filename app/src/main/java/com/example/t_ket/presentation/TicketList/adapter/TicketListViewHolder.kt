package com.example.t_ket.presentation.TicketList.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t_ket.R
import com.example.t_ket.core.domain.model.Ticket

class TicketListViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    val tName = view.findViewById<TextView>(R.id.name)
    val tDni = view.findViewById<TextView>(R.id.dni)
    fun render(ticket: Ticket){
        tName.text = ticket.fullName
        tDni.text = ticket.dni
    }
}
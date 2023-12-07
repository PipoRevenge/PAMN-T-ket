package com.example.t_ket.presentation.TicketList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t_ket.R
import com.example.t_ket.core.domain.model.Ticket

class TicketListAdapter(private val ticketList:List<Ticket>) : RecyclerView.Adapter<TicketListViewHolder>() {

    fun updateList(list:List<Ticket>){
        //horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TicketListViewHolder(layoutInflater.inflate(R.layout.item_ticket, parent, false))
    }



    override fun onBindViewHolder(holder: TicketListViewHolder, position: Int) {
        val item = ticketList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = ticketList.size
}

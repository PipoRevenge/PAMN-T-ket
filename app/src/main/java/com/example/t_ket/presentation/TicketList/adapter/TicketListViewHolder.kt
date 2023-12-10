package com.example.t_ket.presentation.TicketList.adapter


import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.databinding.ItemTicketBinding

class TicketListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTicketBinding.bind(view)

    fun render(ticket: Ticket) {

        binding.itemTitle.text = "Nombre: ${ticket.fullName}"

        binding.itemDni.text = "DNI: ${ticket.dni}"

        binding.itemGid.text = "Id de Grupo: ${ticket.idGroup}"


        //      binding.parent.setOnClickListener {
//              startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)} )
//            onItemSelected(horoscopeInfo)
        }
}
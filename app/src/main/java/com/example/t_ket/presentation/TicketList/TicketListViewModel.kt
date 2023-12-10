package com.example.t_ket.presentation.TicketList
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.core.domain.model.Ticket
import com.example.t_ket.core.domain.repository.EventUseCaseRepository
import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.TicketInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TicketListViewModel @Inject constructor(
    private val ticketProvider: TicketUseCaseRepository
) : ViewModel() {
    private var _ticketlist = MutableLiveData<List<Ticket>>(emptyList())
    val ticketlist: MutableLiveData<List<Ticket>> = _ticketlist
    val ticket1 = Ticket(true, "Juan Pérez", "123456789", "GrupoA")
    val ticket2 = Ticket(false, "María García", "987654321", "GrupoB")
    val ticket3 = Ticket(true, "Pedro López", "456789123", "GrupoC")

    val ticketsList = listOf(ticket1, ticket2, ticket3)
    fun getList() : MutableLiveData<List<Ticket>>{
        viewModelScope.launch {
            _ticketlist.value = ticketProvider.getNotValidatedTickets()
        }
        return ticketlist
    }
}
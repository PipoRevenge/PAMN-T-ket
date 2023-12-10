package com.example.t_ket.presentation.TicketList
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.TicketInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TicketListViewModel @Inject constructor(
    private val eventRepository: EventRepository
) : ViewModel() {
    private val ticketInteractor : TicketUseCaseRepository =  TicketInteractorImpl(eventRepository)
    private val _ticketState: MutableLiveData<Boolean> = MutableLiveData()
    val ticketState: LiveData<Boolean>
        get() = _ticketState

    fun signUp(code: String) {
        viewModelScope.launch {
            var result = ticketInteractor.checkTicketById(code)
            _ticketState.value = result
            Log.d("TAG" ,"Result: $result")
            Log.d("TAG" ,"Comms")
        }
    }
}
package com.example.t_ket.presentation.TicketList
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import com.example.t_ket.core.domain.usecase.TicketInteractorImpl
import kotlinx.coroutines.launch


class TicketListViewModel (
    //private val UserInteractor: UserInteractorImpl
) :  ViewModel() {
    private val ticketInteractor : TicketUseCaseRepository = TicketInteractorImpl()
    private val _ticketState: MutableLiveData<Boolean> = MutableLiveData()
    val ticketState: LiveData<Boolean>
        get() = _ticketState

    fun signUp(code: String) {
        viewModelScope.launch {
            var result = ticketInteractor.checkTicket(code)
            _ticketState.value = result
            Log.d("TAG" ,"Result: $result")
            Log.d("TAG" ,"Comms")
        }
    }
}
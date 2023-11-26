package com.example.t_ket.presentation.TicketList
import android.util.Log
import android.util.Log.println
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.data.users.repository.UserRepository
import com.example.t_ket.data.users.repository.UserRepositoryImpl
import com.example.t_ket.domain.interactor.ticketInteractor.TicketInteractor
import com.example.t_ket.domain.interactor.ticketInteractor.TicketInteractorImpl
import com.example.t_ket.domain.interactor.userInteractor.UserInteractor
import com.example.t_ket.domain.interactor.userInteractor.UserInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class TicketListViewModel (
    //private val UserInteractor: UserInteractorImpl
) :  ViewModel() {
    private val ticketInteractor : TicketInteractor = TicketInteractorImpl()
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
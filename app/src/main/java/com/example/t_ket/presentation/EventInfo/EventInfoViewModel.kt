package com.example.t_ket.presentation.EventInfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.AssociatedUserLoginUseCase
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventInfoViewModel
    @Inject constructor(
    private val eventRepository: EventRepository
) :  ViewModel() {
    private val userInteractor= AssociatedUserLoginUseCase(eventRepository)
    private val _signUpState: MutableLiveData<Boolean> = MutableLiveData()
    val signUpState: LiveData<Boolean>
        get() = _signUpState


    //private fun isValidEmail(email: String): Boolean  = userInteractor.associateUser(email)

}
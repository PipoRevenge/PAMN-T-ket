package com.example.t_ket.presentation.EventInfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.AssociatedUserLoginUseCase
import kotlinx.coroutines.launch


class EventInfoViewModel (
    //private val UserInteractor: UserInteractorImpl
) :  ViewModel() {
    private val userInteractor : UserUseCaseRepository = AssociatedUserLoginUseCase()
    private val _signUpState: MutableLiveData<Boolean> = MutableLiveData()
    val signUpState: LiveData<Boolean>
        get() = _signUpState

    fun signUp(code: String) {
        viewModelScope.launch {
            var result = userInteractor.associateUser(code)
            _signUpState.value = result
            Log.d("TAG" ,"Result: $result")
            Log.d("TAG" ,"Comms")
        }
    }

    //private fun isValidEmail(email: String): Boolean  = userInteractor.associateUser(email)

}
package com.example.t_ket.presentation.EventInfo

import android.util.Log
import android.util.Log.println
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.data.users.repository.UserRepository
import com.example.t_ket.data.users.repository.UserRepositoryImpl
import com.example.t_ket.domain.interactor.userInteractor.UserInteractor
import com.example.t_ket.domain.interactor.userInteractor.UserInteractorImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class EventInfoViewModel (
    //private val UserInteractor: UserInteractorImpl
) :  ViewModel() {
    private val userInteractor : UserInteractor = UserInteractorImpl()
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
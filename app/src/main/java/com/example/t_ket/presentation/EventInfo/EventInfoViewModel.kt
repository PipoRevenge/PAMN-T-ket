package com.example.t_ket.presentation.EventInfo

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

@HiltViewModel
class EventInfoViewModel @Inject constructor(
    private val UserInteractor: UserInteractorImpl
) :  ViewModel() {

    private val _signUpState: MutableLiveData<Boolean> = MutableLiveData()
    val signUpState: LiveData<Boolean>
        get() = _signUpState

    fun signUp(code: String) {
        viewModelScope.launch {
            UserInteractor.asociateUser(code).onEach { state ->
                _signUpState.value = state
            }.launchIn(viewModelScope)
        }
    }


}
package com.example.t_ket.presentation.EventInfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.model.Event
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.AssociatedUserLoginUseCase
import com.example.t_ket.core.domain.usecase.EventInfoGetter
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class EventInfoViewModel @Inject constructor(
    private val eventRepository: EventRepository
) : ViewModel() {
    private val eventsGet= EventInfoGetter(eventRepository)
    private val _eventInfo: MutableLiveData<Event?> = MutableLiveData()
    val eventInfo: LiveData<Event?>
        get() = _eventInfo

    fun getInfo() {
        viewModelScope.launch {
            var info = eventsGet.getEventInfo()
            _eventInfo.value = info
            Log.d("TAG" ,"Result: $info")
            Log.d("TAG" ,"Comms")
        }
    }

}
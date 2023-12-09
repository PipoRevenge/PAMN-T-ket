package com.example.t_ket.core.di
import com.example.t_ket.core.data.eventDi.implementation.EventImpl
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.usecase.TicketInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EventPipoModule {
    @Singleton
    @Provides
    fun provideEventRepository(): EventRepository {
        return EventImpl()
    }
    @Provides
    @Singleton
    fun provideTicketInteractor(eventRepository: EventRepository): TicketInteractorImpl {
        return TicketInteractorImpl(eventRepository)
    }
}

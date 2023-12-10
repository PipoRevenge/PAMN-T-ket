package com.example.t_ket.core.di
import com.example.t_ket.core.data.eventDi.implementation.EventImpl
import com.example.t_ket.core.data.eventDi.repository.EventRepository
import com.example.t_ket.core.domain.repository.EventUseCaseRepository
import com.example.t_ket.core.domain.repository.TicketUseCaseRepository
import com.example.t_ket.core.domain.repository.UserUseCaseRepository
import com.example.t_ket.core.domain.usecase.AssociatedUserLoginUseCase
import com.example.t_ket.core.domain.usecase.EventInfoGetter
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
    fun provideTicketInteractor(eventRepository: EventRepository): TicketUseCaseRepository {
        return TicketInteractorImpl(eventRepository)
    }
    @Provides
    @Singleton
    fun provideEventUseCaseRepository(eventRepository: EventRepository): EventUseCaseRepository {
        return EventInfoGetter(eventRepository)// Proporciona la instancia adecuada de EventUseCaseRepository
    }

    @Provides
    @Singleton
    fun provideUserUseCaseRepository(eventRepository: EventRepository): UserUseCaseRepository {
        return AssociatedUserLoginUseCase(eventRepository) // O utiliza la implementación adecuada
    }
}

package com.example.t_ket.core.di
import com.example.t_ket.core.data.eventDi.implementation.EventImpl
import com.example.t_ket.core.data.eventDi.repository.EventRepository
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

}
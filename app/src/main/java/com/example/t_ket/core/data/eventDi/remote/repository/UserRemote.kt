package com.example.t_ket.core.data.eventDi.remote.repository

interface UserRemote {
    suspend fun isStaff(EventId: String, StaffCode: String): Boolean

}
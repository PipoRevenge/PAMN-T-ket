package com.example.t_ket.data.userDi.remote.repository

interface UserRemote {
    suspend fun isStaff(EventId: String, StaffCode: String): Boolean

}
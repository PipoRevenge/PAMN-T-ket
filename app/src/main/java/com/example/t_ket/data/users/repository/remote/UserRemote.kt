package com.example.t_ket.data.users.repository.remote

interface UserRemote {
    suspend fun isStaff(EventId: String, StaffCode: String): Boolean

}
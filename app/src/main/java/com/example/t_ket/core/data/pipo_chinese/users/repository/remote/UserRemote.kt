package com.example.t_ket.core.data.pipo_chinese.users.repository.remote

interface UserRemote {
    suspend fun isStaff(EventId: String, StaffCode: String): Boolean

}
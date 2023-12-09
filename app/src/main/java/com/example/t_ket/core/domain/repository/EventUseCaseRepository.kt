package com.example.t_ket.core.domain.repository

interface EventUseCaseRepository
{
    fun getNumberOfValidatedTickets(): Int
}
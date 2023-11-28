package com.example.t_ket.core.domain.model

import java.util.Date

data class Ticket(
    var status: Boolean = false, // Validado o no validado
    val fullName: String = "", // Propietario del ticket nombre completo
    //val dni: Int, // Identificador del propietario
    //var checkIn: Date?, // Hora de acceso al evento
    val idGroup: String? = "", // Identificador del grupo (si existe)
)
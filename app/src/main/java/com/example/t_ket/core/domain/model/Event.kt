package com.example.t_ket.core.domain.model

data class Event(
    var capacity: Int? = null,
    var date: String? = "",
    var end_time: String? ="",
    var name: String? = "",
    var organizer: String? = "",
    var start_time: String? ="",
    var imageRef:  String?= ""
)
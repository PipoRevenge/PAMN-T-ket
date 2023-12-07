package com.example.t_ket.core.domain.model

data class Event(
    var capacity: Int? = null,
    var date: String? = "",
    var description: String? = "",
    var end_time: String? ="",
    var location: String? = "",
    var name: String? = "",
    var organizer: String? = "",
    var start_time: String? ="",
    var imageRef:  String?= ""
)
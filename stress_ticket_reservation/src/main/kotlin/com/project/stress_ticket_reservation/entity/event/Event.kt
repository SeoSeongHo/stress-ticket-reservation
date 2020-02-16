package com.project.stress_ticket_reservation.entity.event

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Event(
    @Id
    var event_id: String? = null,
    var event_name: String,
    var last_login_datetime: LocalDateTime,
    var last_page_view_datetime: LocalDateTime,
    var page_view_concert_id: String? = null
)
{
}
package com.project.stress_ticket_reservation.service.store.event

import com.project.stress_ticket_reservation.dto.event.EventDto

interface IEventStore {
    fun updateEvent(eventDto: EventDto)
}
package com.project.stress_ticket_reservation.service.dispatcher

import com.project.stress_ticket_reservation.dto.event.EventDto

interface IEventDispatcher {
    fun dispatchEventToSQS(eventDto: EventDto)
}
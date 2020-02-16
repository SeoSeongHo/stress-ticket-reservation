package com.project.stress_ticket_reservation.mapper.event

import com.project.stress_ticket_reservation.dto.event.EventDto
import com.project.stress_ticket_reservation.entity.event.Event
import java.time.LocalDateTime

class EventMapper {
    companion object {
        fun ToEntity(eventDto: EventDto) : Event {
            return Event(
                    eventDto.event_common.event_id,
                    eventDto.event_name,
                    // last_login_datetime, last_page_view_datetime 두 필드 클라와 맞추기
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    eventDto.event_dic["page_view_concert_id"]
            )
        }
    }
}
package com.project.stress_ticket_reservation.dto.event

import java.util.*

class EventDto(
        var common:Common,
        var event:Event
){

}

data class Common(
        var user_id:String? = null
){

}

data class Event(
        var event_id:String? = null,
        var event_name:String,
        var event_datetime:Date
){

}
package com.project.stress_ticket_reservation.dto.event

import java.util.*

data class EventDto(
        var event_name:String,
        var event_datetime:Date,
        var event_common:Common,
        var event_dic:Map<String, String>
){

}

data class Common(
        var event_id:String? = null
){

}
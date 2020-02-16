package com.project.stress_ticket_reservation.controller

import com.project.stress_ticket_reservation.dto.api.V1Response
import com.project.stress_ticket_reservation.dto.event.EventDto
import com.project.stress_ticket_reservation.service.dispatcher.EventDispatcher
import com.project.stress_ticket_reservation.service.store.event.EventStore
import com.project.stress_ticket_reservation.service.store.userProfile.UserProfileStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/events/")
class EventController(
    @Autowired private val eventDispatcher: EventDispatcher,
    @Autowired private val eventStore: EventStore,
    @Autowired private val userProfileStore: UserProfileStore
){
    @PostMapping("/")
    fun collectEvent (@RequestBody eventDto: EventDto) : V1Response {
        // TODO Exception 분리하기
        try{
            // 0. 이벤트 필터링
            if(filterEvent(eventDto))
                return V1Response(
                        400,
                        "failed to collect event. (Bad Request)"
                )

            // 1. DB 에 데이터 저장
            eventStore.updateEvent(eventDto)

            // 2. 티켓 예약 이벤트이면 Dispatcher 를 통해, 워커로 전달
            if(eventDto.event_name == "reserve_ticket")
                eventDispatcher.dispatchEventToSQS(eventDto);

            return V1Response(
                200,
                    "success to collect event."
            )
        }
        catch(e: Exception){
            return V1Response(
                500,
                    "failed to collect event. (Server Internal Error)"
            )
        }
    }

    fun filterEvent(eventDto: EventDto) : Boolean {
        // 0. user_id 체크
        val userId = eventDto.event_dic.getOrDefault("user_id", "")
        if(userId == "")
            return false

        // 1. 블랙리스트 체크
        if(userProfileStore.getUserProfile(userId).isBlackList)
            return false

        return true
    }
}
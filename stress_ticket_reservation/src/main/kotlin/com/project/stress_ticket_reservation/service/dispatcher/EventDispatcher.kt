package com.project.stress_ticket_reservation.service.dispatcher

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.project.stress_ticket_reservation.dto.event.EventDto
import org.springframework.stereotype.Service
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.SendMessageRequest

@Service
class EventDispatcher : IEventDispatcher {
    private val queueUrl : String = "https://sqs.ap-northeast-2.amazonaws.com/182756308452/ticket_reservation_data_queue"

    override fun dispatchEventToSQS(eventDto: EventDto){
        var retryCount = 0
        val jsonMapper = jacksonObjectMapper()
        try
        {
            val sqs = SqsClient.builder()
                    .region(Region.AP_NORTHEAST_2)
                    .build()

            val sendMesseage: SendMessageRequest = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(jsonMapper.writeValueAsString(eventDto))
                    .delaySeconds(5)
                    .build()
            sqs.sendMessage(sendMesseage)
        }
        catch(E: Exception)
        {
            if(retryCount != 3)
                dispatchEventToSQS(eventDto)
            else
                println("failed to send event to sqs.")
        }
    }

}
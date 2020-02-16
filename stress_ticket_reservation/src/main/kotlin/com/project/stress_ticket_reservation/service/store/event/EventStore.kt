package com.project.stress_ticket_reservation.service.store.event

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.project.stress_ticket_reservation.dao.event.EventDao
import com.project.stress_ticket_reservation.dto.event.EventDto
import com.project.stress_ticket_reservation.mapper.event.EventMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventStore(
        @Autowired private val eventDao:EventDao
) : IEventStore
{
    // TODO 원래는 DDB 를 사용하기로 했으나, 요금적인 문제로 테스트는 인메모리 디비를 통해 테스트
    private val ddbClient: AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withRegion(Regions.AP_NORTHEAST_2)
            .build()

    private val ddbMapper = DynamoDBMapper(ddbClient)
    
    override fun updateEvent(eventDto: EventDto) {
        try{
            eventDao.save(EventMapper.ToEntity(eventDto))
        }
        catch(E : Exception){
            println("failed to update event.")
        }
    }
}
package com.project.stress_ticket_reservation.service.store.userProfile

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.project.stress_ticket_reservation.dao.user.UserProfileDao
import com.project.stress_ticket_reservation.dto.user.UserProfileDto
import com.project.stress_ticket_reservation.mapper.user.UserProfileMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserProfileStore(
        @Autowired private val userProfileDao: UserProfileDao
) : IUserProfileStore {
    // TODO 원래는 DDB 를 사용하기로 했으나, 요금적인 문제로 테스트는 인메모리 디비를 통해 테스트
    private val ddbClient: AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
            .withRegion(Regions.AP_NORTHEAST_2)
            .build()

    private val ddbMapper = DynamoDBMapper(ddbClient)

    override fun updateUserProfile(userProfileDto: UserProfileDto){
        try{
            userProfileDao.save(UserProfileMapper.ToEntity(userProfileDto))
        }
        catch (e: Exception){
            println("failed to update profile by user_id : ${userProfileDto.userId}.")
        }
    }

    override fun getUserProfile(user_id: String) : UserProfileDto {
        try{
            val userProfile = userProfileDao.findByIdOrNull(user_id)
            return UserProfileMapper.ToDto(userProfile)
        }
        catch(e: Exception){
            println("failed to get profile by user_id : $user_id.")
        }
        return UserProfileDto(
                ""
        )
    }
}
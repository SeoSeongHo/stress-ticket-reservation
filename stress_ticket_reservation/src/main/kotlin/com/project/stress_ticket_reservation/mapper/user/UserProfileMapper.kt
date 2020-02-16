package com.project.stress_ticket_reservation.mapper.user

import com.project.stress_ticket_reservation.dto.user.UserProfileDto
import com.project.stress_ticket_reservation.entity.user.UserProfile
import java.time.LocalDateTime
import java.util.*

class UserProfileMapper (){
    companion object{
        fun ToEntity(userProfileDto: UserProfileDto) : UserProfile {
            return UserProfile(
                    userProfileDto.userId,
                    false,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            )
        }

        fun ToDto(userProfile: UserProfile?) : UserProfileDto {
            return UserProfileDto(
                userProfile?.userId ?: "",
                    userProfile?.isBlackList ?: false
            )
        }
    }
}
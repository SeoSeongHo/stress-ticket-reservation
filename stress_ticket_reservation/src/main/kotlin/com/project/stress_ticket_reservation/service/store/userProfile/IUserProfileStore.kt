package com.project.stress_ticket_reservation.service.store.userProfile

import com.project.stress_ticket_reservation.dto.user.UserProfileDto

interface IUserProfileStore {
    fun updateUserProfile(userProfileDto: UserProfileDto)
    fun getUserProfile(user_id: String) : UserProfileDto
}
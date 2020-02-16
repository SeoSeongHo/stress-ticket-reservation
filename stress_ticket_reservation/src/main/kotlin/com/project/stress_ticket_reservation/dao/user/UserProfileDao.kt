package com.project.stress_ticket_reservation.dao.user

import com.project.stress_ticket_reservation.entity.user.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileDao : JpaRepository<UserProfile, String>
package com.project.stress_ticket_reservation.dao.event

import com.project.stress_ticket_reservation.entity.event.Event
import com.project.stress_ticket_reservation.entity.user.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface EventDao : JpaRepository<Event, String>
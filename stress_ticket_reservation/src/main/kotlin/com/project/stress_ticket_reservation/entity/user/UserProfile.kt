package com.project.stress_ticket_reservation.entity.user

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class UserProfile(
        @Id
        var userId: String? = null,
        var isBlackList: Boolean? = false,
        var first_update_datetime: LocalDateTime,
        var last_update_datetime: LocalDateTime
 ){

}
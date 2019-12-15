package com.project.stress_ticket_reservation.entity

import java.util.*
import javax.persistence.*

@Entity
data class UserProfile(
        @Id
        var user_id: String? = null,
        var isBlackList: Boolean,
        var first_update_datetime: Date,
        var last_update_datetime: Date
 ){

}
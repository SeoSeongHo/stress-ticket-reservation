package com.project.stress_ticket_reservation.dto.user

import jdk.nashorn.internal.objects.annotations.Setter

data class UserProfileDto(
        // 추후에 추가될 수 있음
        var userId : String? = null,
        var isBlackList: Boolean = false
){
}
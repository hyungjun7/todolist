package com.hyungjun.todolist.user.dto.service

import com.hyungjun.todolist.user.core.domain.UserRole
import java.time.LocalDateTime

data class UserDto(
	val id: Long,
	val email: String,
	val name: String,
	val role: UserRole,
	val createdAt: LocalDateTime,
	val updatedAt: LocalDateTime
)

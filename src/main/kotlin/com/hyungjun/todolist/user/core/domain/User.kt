package com.hyungjun.todolist.user.core.domain

import java.time.LocalDateTime
import java.util.UUID

class User(
	val id: Long = 0,
	val uniqueKey: UUID = UUID.randomUUID(),
	var password: String,
	var email: String,
	var name: String,
	var role: UserRole = UserRole.USER,
	val createdAt: LocalDateTime = LocalDateTime.now(),
	val updatedAt: LocalDateTime = LocalDateTime.now(),
)

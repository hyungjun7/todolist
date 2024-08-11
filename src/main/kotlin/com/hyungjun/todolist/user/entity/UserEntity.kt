package com.hyungjun.todolist.user.entity

import com.hyungjun.todolist.user.core.domain.UserRole
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Users")
data class UserEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Int = 0,

	@Column(unique = true, nullable = false, length = 36)
	val uniqueKey: String,

	@Column(unique = true, nullable = false, length = 50)
	val email: String,

	@Column(nullable = false)
	val password: String,

	@Column(nullable = false, length = 50)
	val name: String,

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	val role: UserRole = UserRole.USER,

	@Column(nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

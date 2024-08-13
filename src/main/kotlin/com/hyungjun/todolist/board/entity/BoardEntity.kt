package com.hyungjun.todolist.board.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Boards")
data class BoardEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(unique = true, nullable = false, length = 36)
	val boardKey: String,

	@Column(nullable = false)
	val title: String,

	@Column(nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

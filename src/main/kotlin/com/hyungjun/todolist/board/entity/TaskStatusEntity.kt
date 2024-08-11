package com.hyungjun.todolist.board.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TaskStatuses")
data class TaskStatusEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Int = 0,

	@ManyToOne
	@JoinColumn(name = "board_id", nullable = false)
	val board: BoardEntity,

	@Column(nullable = false, length = 100)
	val name: String,

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

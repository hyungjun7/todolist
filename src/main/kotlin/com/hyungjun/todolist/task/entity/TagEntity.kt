package com.hyungjun.todolist.task.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Tags")
data class TagEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Int = 0,

	@Column(nullable = false, length = 100)
	val name: String,

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

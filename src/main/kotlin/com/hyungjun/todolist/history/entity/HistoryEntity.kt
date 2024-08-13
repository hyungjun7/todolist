package com.hyungjun.todolist.history.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Histories")
data class HistoryEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@Column(nullable = false, length = 100)
	val type: String,

	@Column(nullable = false, columnDefinition = "JSON")
	val beforeData: String,

	@Column(nullable = false, columnDefinition = "JSON")
	val afterData: String,

	@Column(nullable = false)
	val createdBy: String,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

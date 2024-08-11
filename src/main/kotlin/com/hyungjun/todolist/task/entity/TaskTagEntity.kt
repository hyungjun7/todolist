package com.hyungjun.todolist.task.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TaskTags")
data class TaskTagEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Int = 0,

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	val task: TaskEntity,

	@ManyToOne
	@JoinColumn(name = "tag_id", nullable = false)
	val tag: TagEntity,

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

package com.hyungjun.todolist.task.entity

import com.hyungjun.todolist.user.entity.UserEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "TaskMemos")
data class TaskMemoEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	val user: UserEntity,

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	val task: TaskEntity,

	@Column(nullable = false)
	val memo: String,

	@Column(nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

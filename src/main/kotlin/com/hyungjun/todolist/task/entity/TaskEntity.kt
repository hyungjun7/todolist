package com.hyungjun.todolist.task.entity

import com.hyungjun.todolist.board.entity.BoardEntity
import com.hyungjun.todolist.board.entity.TaskStatusEntity
import com.hyungjun.todolist.task.core.domain.TaskPriority
import com.hyungjun.todolist.user.entity.UserEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Tasks")
data class TaskEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Int = 0,

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	val user: UserEntity,

	@ManyToOne
	@JoinColumn(name = "board_id", nullable = false)
	val board: BoardEntity,

	@ManyToOne
	@JoinColumn(name = "task_status_id", nullable = false)
	val taskStatus: TaskStatusEntity,

	@Column(unique = true, nullable = false)
	val taskKey: Int,

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	val priority: TaskPriority = TaskPriority.NORMAL,

	@Column(nullable = false)
	val seq: Int,

	@Column(nullable = false)
	val title: String,

	@Column(nullable = false)
	val content: String,

	@Column(nullable = false)
	val dueDate: LocalDateTime,

	@Column(nullable = false)
	val updatedAt: LocalDateTime = LocalDateTime.now(),

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

package com.hyungjun.todolist.task.core.domain

import java.time.LocalDateTime

class Task(
	val id: Long = 0,
	val userId: Long,
	val boardId: Long,
	var taskStatusId: Int,
	val taskKey: String,
	var priority: TaskPriority,
	var seq: Int,
	var title: String,
	var content: String,
	var dueDate: LocalDateTime
)

package com.hyungjun.todolist.task.core.domain

import java.time.LocalDateTime

class Task(
	val id: Int = 0,
	val userId: Int,
	val boardId: Int,
	var taskStatusId: Int,
	val taskKey: Int,
	var priority: TaskPriority,
	var seq: Int,
	var title: String,
	var content: String,
	var dueDate: LocalDateTime
)

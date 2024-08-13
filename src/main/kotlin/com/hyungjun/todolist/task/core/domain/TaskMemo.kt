package com.hyungjun.todolist.task.core.domain

class TaskMemo(
	val id: Long = 0,
	val userId: Long,
	val taskId: Long,
	var memo: String
)

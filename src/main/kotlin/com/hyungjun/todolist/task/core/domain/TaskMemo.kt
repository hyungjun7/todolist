package com.hyungjun.todolist.task.core.domain

class TaskMemo(
	val id: Int = 0,
	val userId: Int,
	val taskId: Int,
	var memo: String
)

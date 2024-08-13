package com.hyungjun.todolist.board.core.domain

class BoardUser(
	val id: Long = 0,
	val userId: Long,
	val boardId: Long,
	var role: BoardUserRole
)

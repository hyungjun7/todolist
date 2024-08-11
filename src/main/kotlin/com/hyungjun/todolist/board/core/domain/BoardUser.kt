package com.hyungjun.todolist.board.core.domain

class BoardUser(
	val id: Int = 0,
	val userId: Int,
	val boardId: Int,
	var role: BoardUserRole
)

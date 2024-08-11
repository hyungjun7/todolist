package com.hyungjun.todolist.user.core.domain

class User(
	val id: Int = 0,
	val uniqueKey: String,
	val email: String,
	var name: String,
	var role: UserRole
)

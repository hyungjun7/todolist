package com.hyungjun.todolist.user.repository

import com.hyungjun.todolist.user.core.domain.User

interface UserRepository {
	fun save(user: User): User
	fun findByEmail(email: String): User?
}

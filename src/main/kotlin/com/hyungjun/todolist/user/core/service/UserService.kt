package com.hyungjun.todolist.user.core.service

import com.hyungjun.todolist.libs.PasswordEncoder
import com.hyungjun.todolist.user.core.domain.User
import com.hyungjun.todolist.user.core.domain.UserRole
import com.hyungjun.todolist.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {
	fun isEmailDuplicated(email: String): Boolean {
		val user = userRepository.findByEmail(email)
		return user != null
	}

	fun saveUser(email: String, name: String, password: String): User {
		val encryptedPassword = this.passwordEncoder.encode(password)
		return this.userRepository.save(User(
			email = email,
			name = name,
			password = encryptedPassword,
			role = UserRole.USER
		))
	}
}

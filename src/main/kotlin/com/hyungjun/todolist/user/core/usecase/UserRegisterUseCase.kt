package com.hyungjun.todolist.user.core.usecase

import com.hyungjun.todolist.user.core.domain.User
import com.hyungjun.todolist.user.core.service.UserService
import com.hyungjun.todolist.user.dto.service.*
import jakarta.validation.Valid
import org.springframework.stereotype.Service

@Service
class UserRegisterUseCase(private val userService: UserService) {
	fun execute(@Valid data: CreateUserDto): User {
		if (this.userService.isEmailDuplicated(data.email)) {
			throw IllegalArgumentException("Email is duplicated")
		}
		return this.userService.saveUser(data.email, data.name, data.password)
	}
}

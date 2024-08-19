package com.hyungjun.todolist.user.dto.service

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateUserDto(
	@field:Email(message = "Invalid email format")
	val email: String,
	@field:NotBlank(message = "Username is required")
	val name: String,
	@field:NotBlank(message = "Password is required")
	@field:Size(min = 8, message = "Password must be at least 8 characters")
	val password: String
)

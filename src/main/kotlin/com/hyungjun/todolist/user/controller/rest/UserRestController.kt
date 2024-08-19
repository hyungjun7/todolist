package com.hyungjun.todolist.user.controller.rest

import com.hyungjun.todolist.user.core.usecase.UserRegisterUseCase
import com.hyungjun.todolist.user.dto.service.*
import com.hyungjun.todolist.user.mapper.UserMapper
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController("/users")
class UserRestController(private val userRegisterUseCase: UserRegisterUseCase, private val userMapper: UserMapper) {
	@PostMapping
	fun registerUser(@RequestBody @Valid data: CreateUserDto): UserDto {
		val user = this.userRegisterUseCase.execute(data)
		return this.userMapper.toDto(user)
	}
}

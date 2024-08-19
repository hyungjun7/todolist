package com.hyungjun.todolist.user.repository

import com.hyungjun.todolist.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository: JpaRepository<UserEntity, Long> {
	fun findByEmail(email: String): Optional<UserEntity>
}

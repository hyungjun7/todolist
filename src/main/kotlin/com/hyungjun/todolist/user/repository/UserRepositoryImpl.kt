package com.hyungjun.todolist.user.repository

import com.hyungjun.todolist.user.core.domain.User
import com.hyungjun.todolist.user.mapper.UserMapper
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
	private val jpaRepository: UserJpaRepository,
	private val userMapper: UserMapper
): UserRepository {

	override fun save(userDomain: User): User {
		val entity = userMapper.toEntityForCreate(userDomain)
		val savedEntity = this.jpaRepository.save(entity)
		return userMapper.toDomain(savedEntity)
	}

	override fun findByEmail(email: String): User? {
		return this.jpaRepository.findByEmail(email)
			.map(userMapper::toDomain)
			.orElse(null)
	}
}

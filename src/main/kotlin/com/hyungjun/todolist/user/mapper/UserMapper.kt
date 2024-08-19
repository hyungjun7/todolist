package com.hyungjun.todolist.user.mapper

import com.hyungjun.todolist.user.core.domain.User
import com.hyungjun.todolist.user.dto.service.UserDto
import com.hyungjun.todolist.user.entity.UserEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserMapper {
	fun toEntity(domain: User): UserEntity
	fun toDomain(entity: UserEntity): User
	fun toDto(domain: User): UserDto

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	fun toEntityForCreate(domain: User): UserEntity
}

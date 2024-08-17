package com.hyungjun.todolist.board.entity

import com.hyungjun.todolist.board.core.domain.BoardUserRole
import com.hyungjun.todolist.user.entity.UserEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "BoardUsers")
data class BoardUserEntity(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	val user: UserEntity,

	@ManyToOne
	@JoinColumn(name = "board_id", nullable = false)
	val board: BoardEntity,

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	val role: BoardUserRole = BoardUserRole.MEMBER,

	@Column
	val deletedAt: LocalDateTime? = null,

	@Column(nullable = false)
	val createdAt: LocalDateTime = LocalDateTime.now()
)

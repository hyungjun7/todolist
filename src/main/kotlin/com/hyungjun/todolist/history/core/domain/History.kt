package com.hyungjun.todolist.history.core.domain

import java.time.LocalDateTime

class History(
	val id: Int = 0,
	val type: String,
	val beforeData: String,  // JSON 형태의 이전 데이터
	val afterData: String,   // JSON 형태의 변경 후 데이터
	val createdBy: String,
	val createdAt: LocalDateTime = LocalDateTime.now()
)

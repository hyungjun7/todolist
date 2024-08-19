package com.hyungjun.todolist.libs

import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Component

@Component
class PasswordEncoder {
	fun encode(password: String): String = BCrypt.hashpw(password, BCrypt.gensalt())
	fun matches(rawPassword: String, encodedPassword: String): Boolean = BCrypt.checkpw(rawPassword, encodedPassword)
}

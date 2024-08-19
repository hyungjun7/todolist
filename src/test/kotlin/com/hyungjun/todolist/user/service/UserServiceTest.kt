package com.hyungjun.todolist.user.service

import com.hyungjun.todolist.libs.PasswordEncoder
import com.hyungjun.todolist.user.core.domain.User
import com.hyungjun.todolist.user.core.service.UserService
import com.hyungjun.todolist.user.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.*
import org.mockito.MockitoAnnotations

class UserServiceTest {

	@Mock
	private lateinit var userRepository: UserRepository

	@Mock
	private lateinit var passwordEncoder: PasswordEncoder

	private lateinit var userService: UserService

	@BeforeEach
	fun setUp() {
		MockitoAnnotations.openMocks(this)
		userService = UserService(userRepository, passwordEncoder)
	}

	@Test
	fun `isEmailDuplicated 이메일이 존재하는 경우 true 를 반환`() {
		val email = "test@example.com"
		`when`(userRepository.findByEmail(email)).thenReturn(User(
			email = email,
			name = "Test User",
			password = "password",
		))

		val result = userService.isEmailDuplicated(email)

		assertTrue(result)
		verify(userRepository).findByEmail(email)
	}

	@Test
	fun `isEmailDuplicated 이메일이 존재하지 않는 경우 false 를 반환`() {
		val email = "test@example.com"
		`when`(userRepository.findByEmail(email)).thenReturn(null)

		val result = userService.isEmailDuplicated(email)

		assertFalse(result)
		verify(userRepository).findByEmail(email)
	}

	@Test
	fun `saveUser 유저 생성 이후 생성된 유저를 반환`() {
		val email = "test@example.com"
		val name = "Test User"
		val password = "password"
		val encryptedPassword = "encryptedPassword"

		`when`(passwordEncoder.encode(password)).thenReturn(encryptedPassword)
		`when`(userRepository.save(any())).thenReturn(User(
			id = 1L,
			email = email,
			name = name,
			password = encryptedPassword
		))

		val result = userService.saveUser(email, name, password)

		print(result.name)
		assertNotNull(result)
		assertEquals(email, result.email)
		assertEquals(name, result.name)
		assertEquals(encryptedPassword, result.password)
		assertEquals(1L, result.id)

		verify(passwordEncoder).encode(password)
		verify(userRepository).save(any())
	}
}

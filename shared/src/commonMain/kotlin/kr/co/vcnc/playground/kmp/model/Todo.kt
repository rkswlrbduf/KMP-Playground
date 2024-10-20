package kr.co.vcnc.playground.kmp.model

import kr.co.vcnc.playground.kmp.getRandomString
import kr.co.vcnc.playground.kmp.randomId
import kotlin.random.Random
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: String,
    val name: String,
    val content: String,
    val createdAt: Long,
    val isDone: Boolean,
) {
    companion object {
        val random: Todo
            get() = Todo(
                id = randomId,
                name = getRandomString(4),
                content = getRandomString(10),
                createdAt = Random(Long.MAX_VALUE).nextLong(),
                isDone = Random.nextBoolean()
            )
    }
}
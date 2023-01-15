package com.yoon.foundation.foundation.web

import com.yoon.foundation.foundation.domain.post.PostsRepository
import com.yoon.foundation.foundation.web.model.PostsSaveRequest
import com.yoon.foundation.foundation.web.model.PostsSaveResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class PostsApiControllerTest(
    @Autowired private val restTemplate: TestRestTemplate,
    @Autowired private val postsRepository: PostsRepository,
    @LocalServerPort private var port: Int,
) {
    @AfterEach
    fun tearDown() {
        postsRepository.deleteAll()
    }

    @Test
    fun Posts_등록() {
        // given
        val title = "title"
        val content = "content"
        val author = "yoonho"
        val body = PostsSaveRequest(
            title = title,
            content = content,
            author = author,
        )

        val url = "http://localhost:$port/api/v1/posts"

        // when
        val response = restTemplate.postForEntity(url, body, PostsSaveResponse::class.java)

        // then
        assertEquals(response.statusCode, HttpStatus.OK)
        assertTrue(response.body?.id!! > 0L)

        val posts = postsRepository.findAll()
        assertEquals(posts[0].title, title)
        assertEquals(posts[0].content, content)
    }
}

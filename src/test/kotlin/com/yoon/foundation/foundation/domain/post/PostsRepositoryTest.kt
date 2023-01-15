package com.yoon.foundation.foundation.domain.post

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime


@ExtendWith(SpringExtension::class)
@SpringBootTest
class PostsRepositoryTest(
    @Autowired private val postsRepository: PostsRepository,
) {
    @AfterEach
    fun cleanup() {
        postsRepository.deleteAll()
    }

    @Test
    fun 게시글저장_불러오기() {
        // given
        val title = "테스트 게시글"
        val content = "테스트 본문"

        postsRepository.save(
            Posts(
                title = title,
                content = content,
                author = "yoonho"
            )
        )
    }

    @Test
    fun BaseTimeEntity_등록() {
        // given
        val now = LocalDateTime.now()
        postsRepository.save(
            Posts(
                title = "title",
                content = "content",
            )
        )

        // when
        val posts = postsRepository.findAll()[0]

        // then
        assertTrue(posts.createdDate!!.isAfter(now))
        assertTrue(posts.modifiedDate!!.isAfter(now))
    }


}
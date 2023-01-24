package com.yoon.foundation.foundation.service.posts

import com.yoon.foundation.foundation.domain.post.Posts
import com.yoon.foundation.foundation.domain.post.PostsRepository
import com.yoon.foundation.foundation.web.model.PostsListResponse
import com.yoon.foundation.foundation.web.model.PostsResponse
import com.yoon.foundation.foundation.web.model.PostsSaveRequest
import com.yoon.foundation.foundation.web.model.PostsUpdateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostsService(
    private val postsRepository: PostsRepository,
) {
    @Transactional
    fun save(
        request: PostsSaveRequest,
    ): Posts {
        return postsRepository.save(request.toEntity())
    }

    @Transactional(readOnly = true)
    fun findById(
        id: Long,
    ): PostsResponse {
        return PostsResponse(
            posts = postsRepository.findById(id)
                .orElseThrow { IllegalAccessException("해당 게시글이 없습니다.") }
        )
    }

    @Transactional(readOnly = true)
    fun findAllDesc(): List<PostsListResponse> {
        return postsRepository.findAllDesc()
            .map {
                PostsListResponse(posts = it)
            }
    }

    fun update(
        id: Long,
        request: PostsUpdateRequest,
    ): Long {
        val post = postsRepository.findById(id)
            .orElseThrow { IllegalArgumentException("해당 사용자가 없습니다. id=$id") }

        post.update(
            title = request.title,
            content = request.content,
        )

        return post.id!!
    }

    fun delete(
        id: Long,
    ): Long {
        val post = postsRepository.findById(id)
            .orElseThrow { IllegalArgumentException("해당 사용자가 없습니다. id=$id") }

        postsRepository.delete(post)

        return post.id!!
    }
}
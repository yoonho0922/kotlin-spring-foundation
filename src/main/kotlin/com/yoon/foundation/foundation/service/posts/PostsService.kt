package com.yoon.foundation.foundation.service.posts

import com.yoon.foundation.foundation.domain.post.Posts
import com.yoon.foundation.foundation.domain.post.PostsRepository
import com.yoon.foundation.foundation.web.model.PostsSaveRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

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
}
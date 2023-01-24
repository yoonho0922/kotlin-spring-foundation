package com.yoon.foundation.foundation.web

import com.yoon.foundation.foundation.service.posts.PostsService
import com.yoon.foundation.foundation.web.model.PostsSaveRequest
import com.yoon.foundation.foundation.web.model.PostsSaveResponse
import com.yoon.foundation.foundation.web.model.PostsUpdateRequest
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/posts")
@RestController
class PostsApiController(
    private val postsService: PostsService,
) {
    @PostMapping
    fun save(
        @RequestBody request: PostsSaveRequest,
    ): PostsSaveResponse {
        return postsService.save(request).run {
            PostsSaveResponse(
                id = id!!,
                title = title,
                createdDate = createdDate,
            )
        }
    }

    @PutMapping("{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody requestDto: PostsUpdateRequest,
    ): Long? {
        return postsService.update(id, requestDto)
    }

    @DeleteMapping("{id}")
    fun delete(
        @PathVariable id: Long,
    ): Long {
        return postsService.delete(id = id)
    }
}
package com.yoon.foundation.foundation.web.model

import com.yoon.foundation.foundation.domain.post.Posts

class PostsSaveRequest(
    val title: String,
    val content: String,
    val author: String,
) {
    fun toEntity(): Posts {
        return Posts(
            title = title,
            content = content,
            author = author,
        )
    }
}
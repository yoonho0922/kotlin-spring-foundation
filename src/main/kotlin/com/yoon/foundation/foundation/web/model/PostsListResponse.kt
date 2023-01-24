package com.yoon.foundation.foundation.web.model

import com.yoon.foundation.foundation.domain.post.Posts
import java.time.LocalDateTime

class PostsListResponse(
    val id: Long,
    val title: String,
    val author: String?,
    val modifiedDate: LocalDateTime?,
){
    constructor(
        posts: Posts
    ) : this(
        id = posts.id!!,
        title = posts.title,
        author = posts.author,
        modifiedDate = posts.modifiedDate,
    )
}
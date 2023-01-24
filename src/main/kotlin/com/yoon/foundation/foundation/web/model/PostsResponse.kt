package com.yoon.foundation.foundation.web.model

import com.yoon.foundation.foundation.domain.post.Posts

class PostsResponse(
    val id: Long,
    val title: String,
    val content: String,
    val author: String?,
){
    constructor(
        posts: Posts
    ) : this(
        id = posts.id!!,
        title = posts.title,
        content = posts.content,
        author = posts.author,
    )
}
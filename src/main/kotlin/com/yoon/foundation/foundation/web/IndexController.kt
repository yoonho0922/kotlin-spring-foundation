package com.yoon.foundation.foundation.web

import com.yoon.foundation.foundation.service.posts.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class IndexController(
    private val postsService: PostsService,
) {
    @GetMapping
    fun index(
        model: Model
    ): String {
        model.addAttribute("posts", postsService.findAllDesc())
        return "index"
    }

    @GetMapping("posts/save")
    fun postsSave(): String {
        return "posts-save"
    }

    @GetMapping("posts/update/{id}")
    fun postsUpdate(
        @PathVariable id: Long,
        model: Model,
    ): String {
        val post = postsService.findById(id = id)
        model.addAttribute("post", post)

        return "posts-update"
    }
}
package com.yoon.foundation.foundation.web.model

import java.time.LocalDateTime

class PostsSaveResponse(
    val id: Long,
    val title: String,
    val createdDate: LocalDateTime?,
)
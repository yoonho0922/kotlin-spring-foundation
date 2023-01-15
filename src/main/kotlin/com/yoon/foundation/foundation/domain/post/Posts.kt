package com.yoon.foundation.foundation.domain.post

import com.yoon.foundation.foundation.domain.BaseTimeEntity
import javax.persistence.*

@Entity
class Posts(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val title: String,
    var content: String,
    val author: String? = null,
) : BaseTimeEntity()
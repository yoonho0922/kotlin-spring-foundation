package com.yoon.foundation.foundation.domain.post

import com.yoon.foundation.foundation.domain.BaseTimeEntity
import javax.persistence.*

@Entity
class Posts(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var content: String,
    val author: String? = null,
) : BaseTimeEntity() {

    fun update(
        title: String,
        content: String,
    ) {
        this.title = title
        this.content = content
    }
}
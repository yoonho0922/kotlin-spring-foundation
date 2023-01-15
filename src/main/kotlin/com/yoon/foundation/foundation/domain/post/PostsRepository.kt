package com.yoon.foundation.foundation.domain.post

import org.springframework.data.jpa.repository.JpaRepository


interface PostsRepository : JpaRepository<Posts, Long>
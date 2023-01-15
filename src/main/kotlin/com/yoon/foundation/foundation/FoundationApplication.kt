package com.yoon.foundation.foundation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class FoundationApplication

fun main(args: Array<String>) {
	runApplication<FoundationApplication>(*args)
}

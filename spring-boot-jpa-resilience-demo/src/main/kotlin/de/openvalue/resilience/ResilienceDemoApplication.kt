package de.openvalue.resilience

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class ResilienceDemoDemoApplication

fun main(args: Array<String>) {
	runApplication<ResilienceDemoDemoApplication>(*args)
}
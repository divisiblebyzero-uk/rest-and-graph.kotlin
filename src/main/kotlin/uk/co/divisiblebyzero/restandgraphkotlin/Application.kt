package uk.co.divisiblebyzero.restandgraphkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import uk.co.divisiblebyzero.restandgraphkotlin.repositories.CountryRepository
import javax.annotation.Resource

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    println("Hello World")

    SpringApplication.run(Application::class.java, *args)
}
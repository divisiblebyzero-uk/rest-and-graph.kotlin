package uk.co.divisiblebyzero.restandgraphkotlin.repositories

import org.springframework.data.repository.CrudRepository
import uk.co.divisiblebyzero.restandgraphkotlin.entities.Country

interface CountryRepository: CrudRepository<Country, Long> {
    fun findByName(name: String): List<Country>
    fun findByLanguage(language: String): List<Country>
}
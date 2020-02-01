package uk.divisiblebyzero.restandgraphkotlin.repositories

import org.springframework.data.repository.CrudRepository
import uk.divisiblebyzero.restandgraphkotlin.entities.City
import uk.divisiblebyzero.restandgraphkotlin.entities.Country

interface CityRepository: CrudRepository<City, Long> {
    fun findByName(name: String): List<City>
}
package uk.divisiblebyzero.restandgraphkotlin.service.restrepositories

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import uk.divisiblebyzero.restandgraphkotlin.entities.City
import uk.divisiblebyzero.restandgraphkotlin.entities.Country

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
interface CountryRestRepository : PagingAndSortingRepository<Country, Long> {
    fun findByName(name:String): List<Country>
    fun findByLanguage(language:String): List<Country>
}
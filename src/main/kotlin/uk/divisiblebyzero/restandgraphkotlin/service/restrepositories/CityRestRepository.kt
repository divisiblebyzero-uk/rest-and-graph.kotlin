package uk.divisiblebyzero.restandgraphkotlin.service.restrepositories

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import uk.divisiblebyzero.restandgraphkotlin.entities.City

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
interface CityRestRepository : PagingAndSortingRepository<City, Long> {
    fun findByName(name:String): List<City>
    fun findBySize(size:String): List<City>
}
package uk.divisiblebyzero.restandgraphkotlin.service.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import uk.divisiblebyzero.restandgraphkotlin.entities.City
import uk.divisiblebyzero.restandgraphkotlin.entities.Country
import uk.divisiblebyzero.restandgraphkotlin.repositories.CityRepository
import uk.divisiblebyzero.restandgraphkotlin.repositories.CountryRepository
import java.util.*
import javax.annotation.Resource

@Component
class GraphQueries(private val countryRepository: CountryRepository, private val cityRepository: CityRepository): GraphQLQueryResolver {
    fun getCountries(): Iterable<Country> {
        return countryRepository.findAll()
    }

    fun getCountry(id:Long): Optional<Country> {
        return countryRepository.findById(id)
    }

    fun getCities(): Iterable<City> {
        return cityRepository.findAll();
    }

    fun getCity(id:Long): Optional<City> {
        return cityRepository.findById(id)
    }
}
package uk.divisiblebyzero.restandgraphkotlin.service.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import uk.divisiblebyzero.restandgraphkotlin.entities.City
import uk.divisiblebyzero.restandgraphkotlin.entities.Country
import uk.divisiblebyzero.restandgraphkotlin.repositories.CityRepository
import uk.divisiblebyzero.restandgraphkotlin.repositories.CountryRepository

@Component
class CountryMutation(private val countryRepository: CountryRepository,
                      private val cityRepository: CityRepository) : GraphQLMutationResolver {

    fun createCountry(name: String, language: String): Country {
        return countryRepository.save(Country(name, language))
    }

    fun createCity(name: String, countryName: String, size: String): City {
        val countries: List<Country> = countryRepository.findByName(countryName)
        if (countries.isEmpty()) {
            throw RuntimeException("Country not found")
        } else if (countries.size > 1) {
            throw RuntimeException("Multiple / duplicate countries found")
        }
        return cityRepository.save(City(name, size, countries[0]))
    }
}

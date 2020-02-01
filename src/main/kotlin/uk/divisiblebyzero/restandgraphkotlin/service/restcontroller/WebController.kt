package uk.divisiblebyzero.restandgraphkotlin.service.restcontroller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.divisiblebyzero.restandgraphkotlin.entities.City
import uk.divisiblebyzero.restandgraphkotlin.entities.Country
import uk.divisiblebyzero.restandgraphkotlin.repositories.CityRepository
import uk.divisiblebyzero.restandgraphkotlin.repositories.CountryRepository

@RestController
class WebController(
    private val countryRepository: CountryRepository,
    private val cityRepository: CityRepository
) {
    @RequestMapping("/manual/listAllCountries")
    fun listAllCountries():Iterable<Country> {
        return countryRepository.findAll();
    }

    @RequestMapping("/manual/listAllCities")
    fun listAllCities():Iterable<City> {
        return cityRepository.findAll();
    }

    @RequestMapping("/manual/insertData")
    fun insertData(): String? {
        val uk: Country = countryRepository.save(
            Country("UK", "English")
        )
        val france: Country = countryRepository.save(
            Country("France", "French")
        )
        val usa: Country = countryRepository.save(
            Country("USA", "Not English")
        )

        cityRepository.save(City("London", "Huge", uk))
        cityRepository.save(City("St Asaph's", "Tiny", uk))
        cityRepository.save(City("Birmingham", "Large", uk))
        cityRepository.save(City("Buford", "Tiny", usa))
        cityRepository.save(City("Los Angeles", "Huge", usa))
        cityRepository.save(City("Paris", "Huge", france))
        return "done"
    }
}
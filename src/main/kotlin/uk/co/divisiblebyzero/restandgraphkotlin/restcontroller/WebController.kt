package uk.co.divisiblebyzero.restandgraphkotlin.restcontroller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.divisiblebyzero.restandgraphkotlin.entities.Country
import uk.co.divisiblebyzero.restandgraphkotlin.repositories.CountryRepository

@RestController
class WebController(private val countryRepository: CountryRepository) {
    @GetMapping("/listAllCountries")
    fun listAllCountries():Iterable<Country> {
        return countryRepository.findAll();
    }

    @RequestMapping("/manual/insertData")
    fun insertData(): String? {
        val uk: Country = countryRepository.save(Country("UK", "English"))
        val france: Country = countryRepository.save(Country("France", "French"))
        val usa: Country = countryRepository.save(Country("USA", "Not English"))
        return "done"
    }
}
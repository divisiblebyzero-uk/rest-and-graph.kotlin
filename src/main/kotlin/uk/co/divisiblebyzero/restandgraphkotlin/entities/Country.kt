package uk.co.divisiblebyzero.restandgraphkotlin.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Country(val name: String, val language: String, @Id @GeneratedValue(strategy= GenerationType.AUTO) var id: Long = 0) {

}
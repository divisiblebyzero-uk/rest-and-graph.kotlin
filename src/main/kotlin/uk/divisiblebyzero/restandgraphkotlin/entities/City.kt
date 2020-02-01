package uk.divisiblebyzero.restandgraphkotlin.entities

import javax.persistence.*

@Entity
data class City(
    val name: String,
    val size: String,
    @ManyToOne
    val country: Country,
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0
)
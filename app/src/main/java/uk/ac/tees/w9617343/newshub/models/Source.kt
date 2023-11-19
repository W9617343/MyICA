package uk.ac.tees.w9617343.newshub.models

data class Source(
    val id: String?,
    val name: String?
){
    constructor() : this(
    null,
    null
    )
}
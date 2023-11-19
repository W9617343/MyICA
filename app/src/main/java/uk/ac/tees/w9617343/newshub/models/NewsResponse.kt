package uk.ac.tees.w9617343.newshub.models

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
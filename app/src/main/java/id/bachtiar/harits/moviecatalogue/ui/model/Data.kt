package id.bachtiar.harits.moviecatalogue.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val movies: List<Movie>? = listOf(),
    val tvshow: List<Movie>? = listOf()
)

@Serializable
data class Movie(
    val title: String? = "",
    val cover: String? = "",
    val releaseDate: String? = "",
    val category: List<String>? = listOf(),
    val subDesc: List<SubDesc>? = listOf(),
    val cast: List<Cast>? = listOf(),
)

data class SubDesc(
    val title: String? = "",
    val description: String? = "",
)

data class Cast(
    val name: String? = "",
    val roleName: String? = "",
    val avatar: String? = "",
)

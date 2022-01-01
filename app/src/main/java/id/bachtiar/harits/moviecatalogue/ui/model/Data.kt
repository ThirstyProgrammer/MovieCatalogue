package id.bachtiar.harits.moviecatalogue.ui.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Data(
    val data: List<Tab>? = listOf(),
)

@Keep
@Serializable
data class Tab(
    val key: String? = "",
    val value: List<Movie>? = listOf()
)

@Keep
@Serializable
data class Movie(
    val title: String? = "",
    val description: String? = "",
    val cover: String? = "",
    val releaseDate: String? = "",
    val category: List<String>? = listOf(),
    val subDesc: List<SubDesc>? = listOf(),
    val cast: List<Cast>? = listOf(),
)

@Keep
@Serializable
data class SubDesc(
    val title: String? = "",
    val description: String? = "",
)

@Keep
@Serializable
data class Cast(
    val name: String? = "",
    val roleName: String? = "",
    val avatar: String? = "",
)

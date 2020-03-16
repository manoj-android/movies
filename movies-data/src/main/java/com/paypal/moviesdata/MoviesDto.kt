package com.paypal.moviesdata

import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.jetbrains.annotations.TestOnly

data class MoviesResponseDto(
    @Json(name = "Search")
    val movies: List<MoviesDto>,

    @Json(name = "totalResults")
    val totalResults: String,

    @Json(name = "Response")
    val response: String
)

data class MoviesDto(
    @Json(name = "Title")
    val title: String?,

    @Json(name = "Year")
    val year: String?,

    @Json(name = "imdbID")
    val imdb: String?,

    @Json(name = "Type")
    val series: String?,

    @Json(name = "Poster")
    val thumbnailUrl: String?
)

@TestOnly
fun main() {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val jsonAdapter: JsonAdapter<MoviesResponseDto> =
        moshi.adapter<MoviesResponseDto>(MoviesResponseDto::class.java)

    val moviesDtoResponseDto: MoviesResponseDto? = jsonAdapter.fromJson(sampleResponse)
    println(moviesDtoResponseDto?.movies)
}

val sampleResponse = """
  {"Search":[{"Title":"The Avengers","Year":"2012","imdbID":"tt0848228","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"},{"Title":"Avengers: Infinity War","Year":"2018","imdbID":"tt4154756","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg"},{"Title":"Avengers: Age of Ultron","Year":"2015","imdbID":"tt2395427","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg"},{"Title":"Avengers: Endgame","Year":"2019","imdbID":"tt4154796","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg"},{"Title":"Avengers: Endgame","Year":"2019","imdbID":"tt4154796","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg"},{"Title":"The Avengers","Year":"1998","imdbID":"tt0118661","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BYWE1NTdjOWQtYTQ2Ny00Nzc5LWExYzMtNmRlOThmOTE2N2I4XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_SX300.jpg"},{"Title":"The Avengers: Earth's Mightiest Heroes","Year":"2010–2012","imdbID":"tt1626038","Type":"series","Poster":"https://m.media-amazon.com/images/M/MV5BYzA4ZjVhYzctZmI0NC00ZmIxLWFmYTgtOGIxMDYxODhmMGQ2XkEyXkFqcGdeQXVyNjExODE1MDc@._V1_SX300.jpg"},{"Title":"Ultimate Avengers","Year":"2006","imdbID":"tt0491703","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDFmZTkxMjktMzRiYS00YzMwLWFhZDctOTQ2N2NlOTAyZDJhXkEyXkFqcGdeQXVyNjgzNDU2ODI@._V1_SX300.jpg"},{"Title":"Ultimate Avengers II","Year":"2006","imdbID":"tt0803093","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BZjI3MTI5ZTYtZmNmNy00OGZmLTlhNWMtNjZiYmYzNDhlOGRkL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg"},{"Title":"The Avengers","Year":"1961–1969","imdbID":"tt0054518","Type":"series","Poster":"https://m.media-amazon.com/images/M/MV5BZWI4ZWM4ZWQtODk1ZC00MzMxLThlZmMtOGFmMTYxZTAwYjc5XkEyXkFqcGdeQXVyMTk0MjQ3Nzk@._V1_SX300.jpg"}],"totalResults":"98","Response":"True"}
""".trimIndent()
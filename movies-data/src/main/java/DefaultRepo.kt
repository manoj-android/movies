import com.paypal.moviesdata.MoviesDto
import com.paypal.moviesdata.MoviesResponseDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


class DefaultRepo {

    private val retrofit: Retrofit = retrofit()

    private val service: MovieService = retrofit.create(MovieService::class.java)

    suspend fun getImage(): List<MoviesDto>? {
        return service.getMoviesList().movies
    }

}

interface MovieService {
    @GET("?apikey=586573af&s=avengers&page=1")
    suspend fun getMoviesList(): MoviesResponseDto
}



fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://www.omdbapi.com")
    .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build()))
    .build()
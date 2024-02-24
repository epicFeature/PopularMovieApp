package com.popularmovieapp.di

import com.popularmovieapp.network.common.Constants
import com.popularmovieapp.network.data.MovieListService
import com.popularmovieapp.network.movielist.MovieListDataApi
import com.popularmovieapp.network.movielist.domain.GetMovieListUseCase
import com.popularmovieapp.network.repository.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {

    @Provides
    @ViewModelScoped
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient().newBuilder().addInterceptor(
                Interceptor { chain ->
                    chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-type", "application/json")
                        .addHeader("X-API-KEY", "J0M94EQ-MAGMZ2N-JEYB7A1-0J2QJ10")//token
                        .build()
                        .let { chain.proceed(it) }
                }
            ).build())
            .build()
    }

    //MovieList

    @Provides
    @ViewModelScoped
    fun provideMovieListDataApi(retrofit: Retrofit): MovieListDataApi {
        return retrofit.create(MovieListDataApi::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideMovieListService(movieListDataApi: MovieListDataApi): MovieListService {
        return MovieListService(movieListDataApi)
    }

    @Provides
    @ViewModelScoped
    fun provideMovieListRepository(movieListService: MovieListService): MovieListRepository {
        return MovieListRepository(movieListService)
    }

    @Provides
    @ViewModelScoped
    fun provideMovieListUseCase(movieListRepository: MovieListRepository): GetMovieListUseCase {
        return GetMovieListUseCase(movieListRepository)
    }

}
package com.popularmovieapp.di

import com.popularmovieapp.movielist.api.ApiConstants
import com.popularmovieapp.movielist.domain.MovieListService
import com.popularmovieapp.movielist.api.MovieListDataApi
import com.popularmovieapp.movielist.domain.GetMovieListUseCase
import com.popularmovieapp.movielist.domain.MovieListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object RetrofitModule {

    @Provides
    @ViewModelScoped
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
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
package com.ersincoskun.taskapp.repo

import com.ersincoskun.taskapp.api.RetrofitAPI
import com.ersincoskun.taskapp.model.Movie
import com.ersincoskun.taskapp.model.Response
import com.ersincoskun.taskapp.roomDb.MovieDao
import java.lang.Exception
import javax.inject.Inject

class MovieRepository @Inject constructor(
    val dao: MovieDao,
    val retrofitAPI: RetrofitAPI
) : MovieRepositoryInterface {
    override suspend fun saveAllMovies(list: List<Movie>) {
        dao.insertMovies(*list.toTypedArray())
    }

    override suspend fun getMovie(id: Long): Movie {
        return dao.getMovie(id)
    }

    override suspend fun getMoviesFromDB(): List<Movie> {
        return dao.getMoviesFromDB()
    }


    override suspend fun getMoviesFromAPI(): Response {
        val emptyResponse = Response(null, null)
        try {
            val response = retrofitAPI.getMovies()
            if (response.isSuccessful) {
                if (response.body() != null) {
                    return response.body() as Response
                } else {
                    return emptyResponse
                }
            } else {
                return emptyResponse
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyResponse
        }
    }

    override suspend fun deleteAllMovies() {
        dao.deleteAllMovies()
    }
}
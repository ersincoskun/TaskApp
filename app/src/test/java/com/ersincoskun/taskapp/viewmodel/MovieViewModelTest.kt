package com.ersincoskun.taskapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ersincoskun.taskapp.MainCoroutineRule
import com.ersincoskun.taskapp.repo.FakeMovieRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule=MainCoroutineRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setup() {
        viewModel = MovieViewModel(FakeMovieRepository())
    }


}
package com.kyawt.shimmertesting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawt.shimmertesting.service.model.movie.Movie
import com.kyawt.shimmertesting.service.model.movie.MovieResult
import com.kyawt.shimmertesting.service.repository.MovieRepository
import kotlinx.coroutines.launch

class SimilarViewModel : ViewModel(){
    var similarMovieResult = MutableLiveData<Movie>()
    var movieRepository = MovieRepository()
    fun loadData(movie_id : Int){
        viewModelScope.launch {
            var result = movieRepository.getSimilarMovie(movie_id)
            similarMovieResult.value = result
        }
    }
}
 package com.example.demoapp.viewmodel

import androidx.lifecycle.*
import com.example.demoapp.entity.Word
import com.example.demoapp.repo.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {


    /**
     *Using LiveData and caching what allWords returns has several benefits:
    * - We can put an observer on the data (instead of polling for changes) and only update the
     *  the UI when the data actually changes.
     * Repository is completely separated from the UI through the ViewModel.
     */


    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */

fun insert(word: Word) = viewModelScope.launch {
    repository.insert(word)
    }


    /**
     * created the ViewModel and implemented a ViewModelProvider.Factory
     * that gets as a parameter the dependencies needed to create WordViewModel: the WordRepository.
     *
     *  Manual Dependency Injection
     */
}
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        if (modelClass.isAssignableFrom(ViewModel ::class.java)) {
            @Suppress ("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }


}

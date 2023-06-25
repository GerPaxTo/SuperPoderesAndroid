package com.gerpax.superpoderesandroid.ui.listaheroes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gerpax.superpoderesandroid.data.Repository
import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _state = MutableStateFlow<List<LocalHero>>(emptyList())
    val state: StateFlow<List<LocalHero>> get() = _state

    private val _stateN = MutableStateFlow(0)

    fun getSuperheros() {
        viewModelScope.launch {
            launch(Dispatchers.IO) {
                val result = withContext(Dispatchers.IO) {
                    repository.getCharacters()
                }

                _state.update { result }
            }
        }
    }

    fun insertHero(hero: LocalHero){
        viewModelScope.launch {
            repository.insertHero(hero)
        }
    }
}
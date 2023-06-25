package com.gerpax.superpoderesandroid.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gerpax.superpoderesandroid.data.Repository
import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import com.gerpax.superpoderesandroid.model.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _state = MutableStateFlow(Characters(0,"","",""))
    val state: StateFlow<Characters> get() = _state

    fun getSuperheros(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = withContext(Dispatchers.IO){
                repository.getCharactersId(id = id)
            }

            _state.update { result }
        }
    }
}


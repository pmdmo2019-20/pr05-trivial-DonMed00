package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.pr05_trivial.data.Repository

class GameViewModelFactory(private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GameViewModel(repository) as T

}

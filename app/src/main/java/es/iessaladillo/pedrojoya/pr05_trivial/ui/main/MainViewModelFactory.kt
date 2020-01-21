package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.pr05_trivial.data.Repository

class MainViewModelFactory(private val repository: Repository, private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(repository, application) as T

}

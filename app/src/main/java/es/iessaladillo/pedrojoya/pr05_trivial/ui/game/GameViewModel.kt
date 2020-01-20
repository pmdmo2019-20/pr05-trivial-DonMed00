package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.Repository
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question

class GameViewModel(private val repository: Repository, private val application: Application) :
    ViewModel() {


    private val _questions: MutableLiveData<List<Question>> = MutableLiveData()
    val questions: LiveData<List<Question>>
        get() = _questions

    lateinit var currentQuestion: Question

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(application)
    }
    private val questionsSize by lazy {
        settings.getInt(
            application.getString(R.string.numberOfQuestions_key), 10
        )
    }

    init {

        refreshList(repository.queryQuestions())


    }

    private fun refreshList(newList: List<Question>) {
        _questions.value= listOf()
        _questions.value = newList.subList(0, questionsSize)
        selectCurrentQuestion()
    }


    private fun selectCurrentQuestion() {
        currentQuestion = _questions.value!![index]
    }

    fun goNextQuestion() {
        index += 1


        //selectCurrentQuestion()
    }

    fun resetIndex() {
        index = 0
    }

    companion object {
        var index = 0
    }


}

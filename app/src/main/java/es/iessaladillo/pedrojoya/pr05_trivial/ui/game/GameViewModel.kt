package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.view.View
import android.widget.RadioButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.Repository
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Answer
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question
import kotlinx.android.synthetic.main.game_fragment.*

class GameViewModel(private val repository: Repository) : ViewModel() {


    private val _questions: MutableLiveData<List<Question>> = MutableLiveData()
    val questions: LiveData<List<Question>>
        get() = _questions

    lateinit var currentQuestion: Question
    lateinit var currentRadioButton: RadioButton
    lateinit var correctAnswer: Answer
    var index = 0

    init {
        refreshLists(repository.queryQuestions())
        selectCurrentQuestion()

    }

    private fun refreshLists(newList: List<Question>) {
        _questions.value = newList
        selectCurrentQuestion()
    }

    private fun selectCurrentQuestion() {
        currentQuestion = _questions.value!![index]
    }

    fun goNextQuestion() {
        index = +1


        selectCurrentQuestion()
    }


}

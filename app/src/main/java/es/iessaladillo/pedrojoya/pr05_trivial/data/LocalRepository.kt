package es.iessaladillo.pedrojoya.pr05_trivial.data

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Answer
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question

object LocalRepository : Repository {


    private val questions: List<Question> = listOf(
        Question(
            "¿Who was the president of EEUU in 2019?",
            Answer("Donald Trump", true),
            Answer("Obama", false),
            Answer("JM Aznar", false),
            Answer("Mickey Mouse", false)
        ),
        Question(
            "¿Where is Sevilla?",
            Answer("Murcia", false),
            Answer("Andalucía", true),
            Answer("Barcelona", false),
            Answer("Salamanca", false)
        )

    )

    init {
        queryQuestions()
    }


    override fun queryQuestions(): List<Question> {
        return questions.shuffled()
    }
}
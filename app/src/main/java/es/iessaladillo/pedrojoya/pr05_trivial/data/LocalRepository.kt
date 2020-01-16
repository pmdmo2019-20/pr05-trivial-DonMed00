package es.iessaladillo.pedrojoya.pr05_trivial.data

import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question

object LocalRepository : Repository {


    private val questions: List<Question> = listOf(
        Question("¿Who was the president of EEUU in 2019?","Donald Trump","Obama","Mickey Mouse","JM Aznar"),
        Question("¿Where is Sevilla?","Andalucia","Islas Canarias","Francía","No existe")
    )
    init {
        orderQuestions()
    }


    var ordenedQuestions: List<Question> = listOf()

    override fun orderQuestions() {
        ordenedQuestions = listOf()
        ordenedQuestions= questions.shuffled()
    }
}
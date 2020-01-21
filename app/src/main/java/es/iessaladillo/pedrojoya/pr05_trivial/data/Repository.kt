package es.iessaladillo.pedrojoya.pr05_trivial.data

import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question

interface Repository {

    fun queryQuestions() :List<Question>
    fun getOrdened() :List<Question>

}
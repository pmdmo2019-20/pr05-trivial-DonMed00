package es.iessaladillo.pedrojoya.pr05_trivial.data.entity

data class Question(
    val question: String,
    val answer1: Answer,
    val answer2: Answer,
    val answer3: Answer,
    val answer4: Answer
)
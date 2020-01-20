package es.iessaladillo.pedrojoya.pr05_trivial.data
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Answer
import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question

object LocalRepository : Repository {


    private val questions: List<Question> = listOf(
        Question(
            "Who was the president of EEUU in 2019?",
            Answer("Donald Trump", true),
            Answer("Obama", false),
            Answer("JM Aznar", false),
            Answer("Mickey Mouse", false)
        ),
        Question(
            "Where is Sevilla?",
            Answer("Murcia", false),
            Answer("Andalucía", true),
            Answer("Barcelona", false),
            Answer("Salamanca", false)
        ),Question(
            "Who is the mayor in Algeciras in 2020?",
            Answer("Jesus Gil", false),
            Answer("Rajoy", false),
            Answer("Landaluce", true),
            Answer("Juan Carlos II", false)
        ),Question(
            "What colour is the White horse of Santiago?",
            Answer("Green", false),
            Answer("Red", false),
            Answer("Black", false),
            Answer("White", true)
        ),Question(
            "Where is Algeciras?",
            Answer("Spain", true),
            Answer("France", false),
            Answer("England", false),
            Answer("EEUU", false)
        ),Question(
            "What is the name of android 9?",
            Answer("Ice Cake", false),
            Answer("Pie", true),
            Answer("Oreo", false),
            Answer("Kit Kat", false)
        ),Question(
            "What is Apple?",
            Answer("A enterprise of food", false),
            Answer("A enterprise of paper", false),
            Answer("A enterprise of technology", true),
            Answer("None", false)
        ),Question(
            "What is graphic card?",
            Answer("A hardware component", false),
            Answer("A component to visualize the software", false),
            Answer("A software of development", false),
            Answer("1 & 2 are corrects", true)
        ),Question(
            "Which one is more recent?",
            Answer("Kotlin", true),
            Answer("C", false),
            Answer("Java", false),
            Answer("C++", false)
        ),Question(
            "What is the meaning of IBM?",
            Answer("International Bacon Made", false),
            Answer("International Business Machines", true),
            Answer("International Bacon Machines", false),
            Answer("Ireland Bacon Machine", false)
        ),Question(
            "What is correct?",
            Answer("World War I (1905)", false),
            Answer("World War II (1857)", false),
            Answer("Cold War (1947)", true),
            Answer("Spanish Civil War (2006)", false)
        ),Question(
            "Which is the most populous country?",
            Answer("Spain", false),
            Answer("Irak", false),
            Answer("Ireland", false),
            Answer("China", true)
        ),Question(
            "Light was invented in ______:",
            Answer("1879", true),
            Answer("1888", false),
            Answer("1456", false),
            Answer("1971", false)
        )

    )

    init {
        queryQuestions()
    }


    override fun queryQuestions(): List<Question> {
        return questions.shuffled()
    }
}
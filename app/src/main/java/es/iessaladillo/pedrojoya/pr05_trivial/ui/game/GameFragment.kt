package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.LocalRepository
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_over.GameOverFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won.GameWonFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainActivity
import kotlinx.android.synthetic.main.game_fragment.*


class GameFragment : Fragment(R.layout.game_fragment) {

    companion object {
        fun newInstance() = GameFragment()
    }

    private val viewModel: GameViewModel by viewModels {
        GameViewModelFactory(LocalRepository)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupAppBar()
        setupRadioGroup()
        setupQuestion()

    }

    private fun setupQuestion() {
        lblQuestion.text = viewModel.currentQuestion.question
        radio1.text = viewModel.currentQuestion.answer1.text
        radio1.isChecked = false

        radio2.text = viewModel.currentQuestion.answer2.text
        radio2.isChecked = false

        radio3.text = viewModel.currentQuestion.answer3.text
        radio3.isChecked = false

        radio4.text = viewModel.currentQuestion.answer4.text
        radio4.isChecked = false

        getAnswer()

    }

    private fun getAnswer() {
        radio1.setOnClickListener {
            btnSubmit.setOnClickListener { submit(viewModel.currentQuestion.answer1.trueOrFalse) }

        }
        radio2.setOnClickListener {
            btnSubmit.setOnClickListener { submit(viewModel.currentQuestion.answer2.trueOrFalse) }

        }
        radio3.setOnClickListener {
            btnSubmit.setOnClickListener { submit(viewModel.currentQuestion.answer3.trueOrFalse) }

        }
        radio4.setOnClickListener {
            btnSubmit.setOnClickListener { submit(viewModel.currentQuestion.answer4.trueOrFalse) }

        }
    }

    private fun submit(trueOrFalse: Boolean) {
        if (trueOrFalse) {
            if (viewModel.index == viewModel.questions.value!!.size - 1) {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fcTitle, GameWonFragment.newInstance())

                    .commit()

            } else {
                goNextQuestion()
                setupQuestion()
                setupAppBar()
            }
        } else {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.fcTitle, GameOverFragment.newInstance())
                .addToBackStack(MainActivity.TAG_TITLE_FRAGMENT)
                .commit()

        }
    }

    private fun goNextQuestion() {
        viewModel.goNextQuestion()
    }


    private fun setupRadioGroup() {
        radio1.setOnClickListener { }
    }


    private fun setupAppBar() {
        val text: String = getString(
            R.string.game_question_title,
            viewModel.index + 1,
            viewModel.questions.value!!.size
        )
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = text
        }
    }


}


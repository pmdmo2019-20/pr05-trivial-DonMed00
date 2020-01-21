package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.LocalRepository
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_over.GameOverFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won.GameWonFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainActivity.Companion.flag
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainViewModelFactory
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainViewModel.Companion.index
import kotlinx.android.synthetic.main.game_fragment.*


class GameFragment : Fragment(R.layout.game_fragment) {

    companion object {
        fun newInstance() = GameFragment()
    }

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }
     private val questionsSize by lazy {
        settings.getInt(
            getString(R.string.numberOfQuestions_key),10
        )
    }

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(LocalRepository,activity!!.application)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupViews()
    }

    private fun setupViews() {

        //viewModel.refreshList(LocalRepository.queryQuestions())

        setupAppBar()
        setupQuestion()

    }


    private fun setupQuestion() {
        //viewModel.refreshList(LocalRepository.queryQuestions())

        lblQuestion.text = viewModel.questions.value!![index].question

        radio1.text = viewModel.questions.value!![index].answer1.text

        radio2.text = viewModel.questions.value!![index].answer2.text

        radio3.text = viewModel.questions.value!![index].answer3.text

        radio4.text = viewModel.questions.value!![index].answer4.text

        getAnswer()

    }

    private fun getAnswer() {
        radio1.setOnClickListener {
            btnSubmit.setOnClickListener { submit(viewModel.questions.value!![index].answer1.trueOrFalse) }

        }
        radio2.setOnClickListener {

            btnSubmit.setOnClickListener { submit(viewModel.questions.value!![index].answer2.trueOrFalse) }

        }
        radio3.setOnClickListener {

            btnSubmit.setOnClickListener { submit(viewModel.questions.value!![index].answer3.trueOrFalse) }

        }
        radio4.setOnClickListener {


            btnSubmit.setOnClickListener { submit(viewModel.questions.value!![index].answer4.trueOrFalse) }

        }
    }

    private fun submit(trueOrFalse: Boolean) {
        if (trueOrFalse) {
            if (index == viewModel.questions.value!!.size - 1) {
                flag=true
                viewModel.resetIndex()
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fcTitle, GameWonFragment.newInstance())
                    .commit()

            } else {
                flag=false
                goNextQuestion()
               // setupAppBar()
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fcTitle, newInstance())
                    .commit()
            }
        } else {
            flag=true
            viewModel.resetIndex()
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.fcTitle, GameOverFragment.newInstance())
                .commit()

        }
    }

    private fun goNextQuestion() {
        viewModel.goNextQuestion()
    }


    private fun setupAppBar() {
        val text: String = getString(
            R.string.game_question_title,
            index +1,
            questionsSize
        )
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            title = text
        }
    }


}


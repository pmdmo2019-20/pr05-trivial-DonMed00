package es.iessaladillo.pedrojoya.pr05_trivial.ui.title

import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import kotlinx.android.synthetic.main.title_fragment.*

class TitleFragment : Fragment(R.layout.title_fragment) {

    companion object {
        fun newInstance() = TitleFragment()
        private const val TAG_GAME_FRAGMENT = "TAG_GAME_FRAGMENT"
    }

    private val viewModel: TitleViewModel by viewModels()




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.title_fragment, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setupViews() {
        setupAppBar()
        setupBtnPlay()
    }

    private fun setupBtnPlay() {
        btnPlay.setOnClickListener { startGame() }
    }

    private fun startGame() {
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, GameFragment.newInstance())
            .commit()
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
            setTitle(R.string.app_name)
        }
    }


}

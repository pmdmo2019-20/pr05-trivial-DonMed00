package es.iessaladillo.pedrojoya.pr05_trivial.ui.game_over


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import kotlinx.android.synthetic.main.fragment_game_over.*
import kotlinx.android.synthetic.main.fragment_game_won.*

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment(R.layout.fragment_game_over) {


        companion object {
            fun newInstance() = GameOverFragment()
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            setupViews()
        }

        private fun setupViews() {
            setupAppBar()
            setupBtnTryAgain()
        }

    private fun setupBtnTryAgain() {
        btnTryAgain.setOnClickListener { newMatch() }
    }

    private fun newMatch() {
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, GameFragment.newInstance())
            .commit()
    }

        private fun setupAppBar() {
            (requireActivity() as AppCompatActivity).supportActionBar?.run {
                setDisplayHomeAsUpEnabled(true)
                setTitle(R.string.game_over_title)
            }
        }

}

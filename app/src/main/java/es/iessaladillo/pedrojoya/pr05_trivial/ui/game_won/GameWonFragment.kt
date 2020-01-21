package es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import kotlinx.android.synthetic.main.fragment_game_won.*

/**
 * A simple [Fragment] subclass.
 */
class GameWonFragment : Fragment(R.layout.fragment_game_won) {

    companion object {
        fun newInstance() = GameWonFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupAppBar()
        setupBtnNextMatch()
    }

    private fun setupBtnNextMatch() {
        btnYouWin.setOnClickListener { newMatch() }
    }

    private fun newMatch() {
        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, GameFragment.newInstance())
            .commit()
    }

    private fun setupAppBar() {
        
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.game_won_imgYouWin)
        }
    }




}

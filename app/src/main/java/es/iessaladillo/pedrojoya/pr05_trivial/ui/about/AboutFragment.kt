package es.iessaladillo.pedrojoya.pr05_trivial.ui.about


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment(R.layout.fragment_about) {


    companion object {
        fun newInstance() = AboutFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupAppBar()
    }

    private fun setupAppBar() {
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.about_title)
        }
    }

}

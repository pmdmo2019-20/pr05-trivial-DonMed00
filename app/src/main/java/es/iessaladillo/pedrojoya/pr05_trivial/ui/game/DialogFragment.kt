package es.iessaladillo.pedrojoya.pr05_trivial.ui.game


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment

/**
 * A simple [Fragment] subclass.
 */
class DialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.main_confirmation)
            builder.setMessage(R.string.main_quit_game)
                .setPositiveButton(R.string.main_yes) { _, _ ->
                    activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.fcTitle, TitleFragment.newInstance())
                        .commit()
                }
                .setNegativeButton(R.string.main_no) { _, _ ->

                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}

// ...





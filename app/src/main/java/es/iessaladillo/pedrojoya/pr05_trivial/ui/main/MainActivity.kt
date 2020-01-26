package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.LocalRepository
import es.iessaladillo.pedrojoya.pr05_trivial.ui.about.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.DialogFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.settings.SettingFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(LocalRepository,application)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigateToInitialDestination()
        }
        setupViews()


    }

    private fun navigateToInitialDestination() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, TitleFragment.newInstance())
            .commit()
    }

    private fun setupViews() {
        setupAppBar()
    }

    private fun setupAppBar() {
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.mnuRules -> {
                navigateToRules()
                true
            }
            R.id.mnuAbout -> {
                navigateToAbout()
                true
            }
            R.id.mnuSettings -> {
                navigateToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    override fun onBackPressed() {
        viewModel.resetIndex()
         val showDialog by lazy {
            settings.getBoolean(
                getString(R.string.prefConfirmSave_key), true
            )
        }
        if (supportFragmentManager.findFragmentById(R.id.fcTitle) is GameFragment && (showDialog)) {
            showConfirmationDialog()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fcTitle, TitleFragment.newInstance())
                .commit()
        }

    }


    private fun showConfirmationDialog() {
        DialogFragment().show(supportFragmentManager, "Dialog Confirmation")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun navigateToRules() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, RulesFragment.newInstance())
            .commit()
    }

    private fun navigateToAbout() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, AboutFragment.newInstance())
            .commit()
    }

    private fun navigateToSettings() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle, SettingFragment())
            .commit()
    }


    companion object {
        var flag : Boolean = true
    }

}

package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            navigateToInitialDestination()
        }
        setupViews()
        setupAppBar()

    }

    private fun navigateToInitialDestination() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle,TitleFragment.newInstance(), Companion.TAG_TITLE_FRAGMENT)
            .commit()
    }


    private fun setupViews() {
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
            else -> super.onOptionsItemSelected(item)
        }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun navigateToRules() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcTitle,RulesFragment.newInstance())
            .addToBackStack(TAG_TITLE_FRAGMENT)
            .commit()
        }

    companion object {
        private const val TAG_TITLE_FRAGMENT = "TAG_TITLE_FRAGMENT"
    }

}

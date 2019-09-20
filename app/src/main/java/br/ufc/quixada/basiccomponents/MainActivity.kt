package br.ufc.quixada.basiccomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.ufc.quixada.basiccomponents.views.SettingsActivity
import br.ufc.quixada.basiccomponents.views.HomeActivity
import br.ufc.quixada.basiccomponents.views.MusicPlayActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private lateinit var pageViewAdapter: PageViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val actionBar = supportActionBar

        actionBar!!.title = "Task Manager"
        actionBar.subtitle = "1st Mobile Exam"
        actionBar.elevation = 4.0F
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setLogo(R.mipmap.ic_launcher)
        actionBar.setDisplayUseLogoEnabled(true)

        startFragment()
    }

    private fun startFragment() {
        val homeFragment = HomeActivity()
        supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, homeFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.music -> {
                val musicIntent = Intent(this, MusicPlayActivity::class.java)
                startActivity(musicIntent)
                return true
            }
            R.id.settings -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

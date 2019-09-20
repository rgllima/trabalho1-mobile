package br.ufc.quixada.basiccomponents.views

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.ufc.quixada.basiccomponents.R
import kotlinx.android.synthetic.main.settings.*

class SettingsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var languages = arrayOf("Português", "Inglês", "Espanhol", "Alemão", "Chinês")
    var spinner: Spinner? = null
    var selectedItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        setSupportActionBar(toolbar2)

        val toolbar = supportActionBar
        toolbar?.title = "Settings"
        toolbar?.setDisplayHomeAsUpEnabled(true)

        spinner = this.settingsSpinner
        spinner!!.onItemSelectedListener = this

        val myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = myAdapter
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        selectedItem = languages[p2]
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
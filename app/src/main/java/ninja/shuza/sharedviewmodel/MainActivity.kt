package ninja.shuza.sharedviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.layout_top, InputFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.layout_bottom, OutputFragment()).commit()

        val message = resources.getString(R.string.show_input)

        val sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)

        sharedViewModel.inputNumber.observe(this, Observer {
            it?.let {
                tv_show_input.text = "$message  $it"
            }
        })
    }
}
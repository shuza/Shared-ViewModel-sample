package ninja.shuza.sharedviewmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), Communicator {

    private var inputFrgament: InputFragment by Delegates.notNull()
    private var outputFragment: OutputFragment by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputFrgament = InputFragment()
        inputFrgament.activityListener = this
        outputFragment = OutputFragment()


        supportFragmentManager.beginTransaction().add(R.id.layout_top, inputFrgament).commit()
        supportFragmentManager.beginTransaction().add(R.id.layout_bottom, outputFragment).commit()
    }

    override fun passData(number: Int) {
        val message = resources.getString(R.string.show_input)
        tv_show_input.text = "$message  $number"

        outputFragment.passDataToAnotherFragment(number)
    }
}
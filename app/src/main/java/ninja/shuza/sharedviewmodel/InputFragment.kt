package ninja.shuza.sharedviewmodel

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_input.*

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  09-Aug-2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

class InputFragment : Fragment() {

    private var sharedViewModel: SharedViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.let {
            /**
             *  create view model in activity scope
             */
            sharedViewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }

        et_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(txt: CharSequence?, p1: Int, p2: Int, p3: Int) {
                txt?.let {
                    var input = 0
                    if (txt.toString().isNotEmpty()) {
                        input = txt.toString().toInt()
                    }

                    sharedViewModel?.inputNumber?.postValue(input)
                }
            }
        })
    }

}
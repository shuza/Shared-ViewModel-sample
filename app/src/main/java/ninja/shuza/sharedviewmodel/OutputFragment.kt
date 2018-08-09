package ninja.shuza.sharedviewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_output.*

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
class OutputFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_output, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**
         *  create view model in activity scope
         */
        activity?.let {
            val sharedViewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)

            observeInput(sharedViewModel)
        }
    }

    private fun observeInput(sharedViewModel: SharedViewModel) {
        sharedViewModel.inputNumber.observe(this, Observer {
            it?.let {
                tv_output.text = "2 x $it  =  ${2 * it}"
            }
        })
    }

}
package ninja.shuza.sharedviewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  09-Aug-18
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.ninja
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

class SharedViewModel:ViewModel(){
    val inputNumber = MutableLiveData<Int>()
}
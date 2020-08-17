package com.dontsu.containerspinner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel: ViewModel() {

    val month = MutableLiveData<String>()

}

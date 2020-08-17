package com.dontsu.containerspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dontsu.containerspinner.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

//Spinner는 Adapter를 만들어야 사용할 수 있다.

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemViewModel
    private lateinit var binding: ActivityMainBinding

    init {
        //Timber initialize
        Timber.plant(Timber.DebugTree())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.lifecycleOwner = this
        //뷰모델 연결
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding.model = viewModel

        val data = listOf("- 선택하세요 -", "1월", "2월", "3월", "4월", "5월", "6월")

        spinner.apply {
            adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, data)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    viewModel.month.value = data[position]
                    //monthObserving()
                }
            }
        }
    }

    /*fun monthObserving() {
        viewModel.month.observe(this@MainActivity, Observer { month ->
            //UI 업데이트
            binding.result.text = month
        })
    }*/

}

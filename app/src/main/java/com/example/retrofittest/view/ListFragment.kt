package com.example.retrofittest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.retrofittest.R
import com.example.retrofittest.WeatherData
import com.example.retrofittest.model.WeatherListAdapter
import com.example.retrofittest.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    lateinit var myViewModel: MyViewModel
    var  listAdapter = WeatherListAdapter()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel= ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.fetchFromRemote()
        weather_recyclerview.adapter=listAdapter
        weather_recyclerview.layoutManager=LinearLayoutManager(context)
        observeViewModel()

    }
    fun observeViewModel(){
        val nameObserver = Observer<WeatherData> { data ->
            // Update the UI, in this case, a TextView.
            listAdapter.setData(data)
        }
        myViewModel.weatherLiveData.observe(viewLifecycleOwner, nameObserver)


    }

}

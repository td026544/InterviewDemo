package com.example.retrofittest.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.R
import com.example.retrofittest.WeatherData
import kotlinx.android.synthetic.main.weather_item.view.*

class WeatherListAdapter:RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>(){
    class WeatherViewHolder(var view: View):RecyclerView.ViewHolder(view)

    var weatherData : WeatherData? = null
    fun setData(data: WeatherData){
        this.weatherData=data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.weather_item,parent,false)
        return  WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        var size:Int = 0
        if(weatherData==null){
            return size
        }
        else{
            size= weatherData!!.records.location[0].weatherElement[2].time.size
            return  size*2
        }
    }



    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        if (position%2==0){
            holder.view.type_a_layout.visibility=View.VISIBLE
            var startTime:String=weatherData!!.records.location[0].weatherElement[2].time[position/2].startTime
            var endTime:String=weatherData!!.records.location[0].weatherElement[2].time[position/2].endTime
            var temp:String=weatherData!!.records.location[0].weatherElement[2].time[position/2].parameter.parameterName+"°C"

            holder.view.start_time_txt.text= startTime
            holder.view.end_time_txt.text= endTime
            holder.view.temperature_txt.text= temp

            val bundle = bundleOf("start_time" to startTime,
                "end_time" to endTime,"temp" to temp)
            holder.view.type_a_layout.setOnClickListener({
                Navigation.findNavController(it).navigate(R.id.action_listFragment_to_detailFragment,bundle);
            })

        }
        else{
            holder.view.type_b_layout.visibility=View.VISIBLE

        }





    }
}
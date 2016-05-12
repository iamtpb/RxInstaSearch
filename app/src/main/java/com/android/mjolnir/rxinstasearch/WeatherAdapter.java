package com.android.mjolnir.rxinstasearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.mjolnir.rxinstasearch.Model.Cities;
import java.util.List;

/**
 * Created by sam_chordas on 5/12/16.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

  private List<Cities.List> list;

  public WeatherAdapter(List<Cities.List> list){
    this.list = list;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_weather, parent, false);
    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Cities.List listItem = list.get(position);

    holder.city.setText(listItem.getName());
    holder.temp.setText(String.valueOf(listItem.getMain().getTemp()));
    holder.tempMin.setText(String.valueOf(listItem.getMain().getTempMin()));
    holder.tempMax.setText(String.valueOf(listItem.getMain().getTempMax()));
    holder.windSpeed.setText(String.valueOf(listItem.getWind().getSpeed()));
    holder.weatherMain.setText(String.valueOf(listItem.getWeather().get(0).getMain()));
    holder.weatherDescription.setText(String.valueOf(listItem.getWeather().get(0).getDescription()));
  }

  @Override public int getItemCount() {
    return list.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder{
    public TextView city;
    public TextView temp;
    public TextView tempMin;
    public TextView tempMax;
    public TextView windSpeed;
    public TextView weatherMain;
    public TextView weatherDescription;

    public ViewHolder(View v){
      super(v);
      city = (TextView) v.findViewById(R.id.city);
      temp = (TextView) v.findViewById(R.id.temp);
      tempMin = (TextView) v.findViewById(R.id.temp_min);
      tempMax = (TextView) v.findViewById(R.id.temp_max);
      windSpeed = (TextView) v.findViewById(R.id.wind_speed);
      weatherMain = (TextView) v.findViewById(R.id.weather_main);
      weatherDescription = (TextView) v.findViewById(R.id.weather_description);
    }
  }

  public void swapList(List<Cities.List> list){
    this.list = list;
    notifyDataSetChanged();
  }
}

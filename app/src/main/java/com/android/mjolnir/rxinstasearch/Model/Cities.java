package com.android.mjolnir.rxinstasearch.Model;

import java.util.List;

/**
 * Created by sam_chordas on 5/3/16.
 */
public class Cities {
  private java.util.List<List> list;

  public void setList(java.util.List<List> list){
    this.list = list;
  }

  public java.util.List<List> getList(){
    return list;
  }

  public class List{
    private String name;
    private Main main;
    private Wind wind;
    private java.util.List<Weather> weather;

    public void setName(String name){
      this.name = name;
    }
    public String getName(){
      return name;
    }

    public void setMain(Main main){
      this.main = main;
    }

    public Main getMain(){
      return main;
    }

    public void setWind(Wind wind){
      this.wind = wind;
    }

    public Wind getWind(){
      return wind;
    }

    public void setWeather(java.util.List<Weather> weather){
      this.weather = weather;
    }

    public java.util.List<Weather> getWeather(){
      return weather;
    }

    public class Main{
      private double temp;
      private double tempMin;
      private double tempMax;

      public void setTemp(double temp){
        this.temp = temp;
      }

      public double getTemp(){
        return temp;
      }

      public void setTempMin(double tempMin){
        this.tempMin = tempMin;
      }

      public double getTempMin(){
        return tempMin;
      }

      public void setTempMax(double tempMax){
        this.tempMax = tempMax;
      }

      public double getTempMax(){
        return tempMax;
      }
    }

    public class Wind{
      private double speed;
      private double deg;

      public void setSpeed(double speed){
        this.speed = speed;
      }

      public double getSpeed(){
        return speed;
      }

      public void setDeg(double deg){
        this.deg = deg;
      }

      public double getDeg(){
        return deg;
      }
    }
    public class Weather{
      private String main;
      private String description;
      private String icon;

      public void setMain(String main){
        this.main = main;
      }

      public String getMain(){
        return main;
      }

      public void setDescription(String description){
        this.description = description;
      }

      public String getDescription(){
        return description;
      }

      public void setIcon(String icon){
        this.icon = icon;
      }

      public String getIcon(){
        return icon;
      }
    }
  }
}

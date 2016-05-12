package com.android.mjolnir.rxinstasearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.android.mjolnir.rxinstasearch.Model.Cities;
import com.android.mjolnir.rxinstasearch.Service.WeatherService.WeatherAPI;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  private List<Cities.List> list;
  private WeatherAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Retrofit retrofit = new Retrofit.Builder()
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(getString(R.string.API_BASE_URL))
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    list = new ArrayList<Cities.List>();
    adapter = new WeatherAdapter(list);
    WeatherAPI service = retrofit.create(WeatherAPI.class);
    Observable<Cities> observable = service.getCities(31.4, 36.7, 10);

    observable
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Cities>() {
          @Override public void call(Cities cities) {
            list = cities.getList();
          }
        }, new Action1<Throwable>() {
          @Override public void call(Throwable throwable) {
            Log.e(getClass().getSimpleName(), "Error: " + throwable);
          }
        });
  }
}

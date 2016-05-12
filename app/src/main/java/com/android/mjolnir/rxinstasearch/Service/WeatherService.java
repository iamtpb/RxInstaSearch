package com.android.mjolnir.rxinstasearch.Service;

import com.android.mjolnir.rxinstasearch.Model.Cities;
import retrofit.http.Query;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by sam_chordas on 5/3/16.
 */
public class WeatherService {
  public interface WeatherAPI{
    @GET("find/{lat}/{lon}/{cnt}")
    Observable<Cities> getCities(@Query("lat") double lat, @Query("lon") double lon,
        @Query("cnt") int cnt);
  }
}

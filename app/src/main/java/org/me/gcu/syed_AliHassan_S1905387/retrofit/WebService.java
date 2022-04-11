package org.me.gcu.syed_AliHassan_S1905387.retrofit;

import org.me.gcu.syed_AliHassan_S1905387.Been.CurrentIncidents.RssFeed;
import org.me.gcu.syed_AliHassan_S1905387.Been.RoadWorkRssFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET("rss/feeds/currentincidents.aspx")
    Call<RssFeed> getCurrentIncidents();

    @GET("rss/feeds/roadworks.aspx")
    Call<RoadWorkRssFeed> getRoadWork();

    @GET("rss/feeds/plannedroadworks.aspx")
    Call<RoadWorkRssFeed> getPlannedworkd();

}

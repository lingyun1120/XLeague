package com.xtp.league.http;

import com.xtp.league.pojo.DoubanTopBean;
import com.xtp.league.pojo.GankBeautyBean;
import com.xtp.league.pojo.GankDetailBean;
import com.xtp.league.pojo.MovieDetailBean;
import com.xtp.league.pojo.WanArticleBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {

    String GANK_URL = "http://gank.io/api/";
    String DOUBAN_URL = "https://api.douban.com/";
    String WAN_URL = "http://www.wanandroid.com/";

    @GET("data/福利/{count}/{page}")
    Flowable<GankBeautyBean> getBeauty(@Path("count") int count, @Path("page") int page);

    @GET("day/{year}/{month}/{day}")
    Flowable<GankDetailBean> getDetail(@Path("year") String year, @Path("month") String month, @Path("day") String day);

    //----------------------------------------------------------------------------------------------
    @GET("v2/movie/top250")
    Flowable<DoubanTopBean> getMovieTop(@Query("start") int start, @Query("count") int count);
    @GET("v2/movie/subject/{id}")
    Flowable<MovieDetailBean> getMovieDetail(@Path("id") String id);

    //----------------------------------------------------------------------------------------------
    @GET("article/list/{page}/json")
    Flowable<WanArticleBean> getArticleList(@Path("page") int page);
}

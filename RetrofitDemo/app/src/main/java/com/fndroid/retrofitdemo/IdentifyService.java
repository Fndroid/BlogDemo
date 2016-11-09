package com.fndroid.retrofitdemo;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/10/28.
 */

public interface IdentifyService{
    @GET("listBlogs")
    public Observable<Blogs> getBlogs();
}


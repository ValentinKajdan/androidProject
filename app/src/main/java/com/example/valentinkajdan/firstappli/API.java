package com.example.valentinkajdan.firstappli;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by valentinkajdan on 17/03/2017.
 */


public interface API {
    @GET("?json=get_recent_posts")
    Call<ResponseLastPosts> getLastPosts(@Query("read_more") String read_more);


    @GET("?json=get_category_index")
    Call<ResponseCategories> getCategories(@Query("read_more") String read_more);
}

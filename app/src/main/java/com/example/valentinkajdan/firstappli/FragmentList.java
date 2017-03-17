package com.example.valentinkajdan.firstappli;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by valentinkajdan on 15/03/2017.
 */

class FragmentList extends Fragment implements OnListItemClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout ,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final RecyclerView rView = (RecyclerView) view.findViewById(R.id.recyclerview);
        rView.setLayoutManager(new LinearLayoutManager(getContext()));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.goglasses.fr/")
                .addConverterFactory(
                        JacksonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        //Récupérer les derniers articles
        Call<ResponseLastPosts> call = api.getLastPosts(getResources().getString(R.string.read_more));
        call.enqueue(new Callback<ResponseLastPosts>() {
            @Override
            public void onResponse(Call<ResponseLastPosts> call, Response<ResponseLastPosts> response) {
                ArrayList<Post> lastPosts = response.body().posts;
                rView.setAdapter(new MyAdapter(lastPosts, FragmentList.this));

                //Insert des nouveaux articles en base
                SQLiteDatabase db = new
                        DatabaseHelper(getContext()).getWritableDatabase();

                ContentValues cv = new ContentValues();
                cv.put("message","blabla");
                db.insert("post", null, cv);
                db.query("post", lastPosts, )
                db.close();
            }

            @Override
            public void onFailure(Call<ResponseLastPosts> call, Throwable t) {

                Log.i("Failure",t.toString());

            }
        });

        //Récupérer les catégories
        Call<ResponseCategories> callCat = api.getCategories(getResources().getString(R.string.read_more));
        callCat.enqueue(new Callback<ResponseCategories>() {
            @Override
            public void onResponse(Call<ResponseCategories> call, Response<ResponseCategories> response) {
                ArrayList<Category> categories = response.body().categories;
                Log.i(TAG, "onResponse: "+categories.size());
            }

            @Override
            public void onFailure(Call<ResponseCategories> call, Throwable t) {

            }
        });





    }

    @Override
    public void onHeaderClicked(Post post) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("post", (Parcelable) post);
        startActivity(intent);
    }

    @Override
    public void onItemClicked(Post post) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("post", (Parcelable) post);
        startActivity(intent);
    }
}

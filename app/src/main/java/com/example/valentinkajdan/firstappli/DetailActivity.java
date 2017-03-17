package com.example.valentinkajdan.firstappli;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by valentinkajdan on 14/03/2017.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, FragmentDetail.newInstance((Post) getIntent().getParcelableExtra("post")))
                .commitAllowingStateLoss();
    }

}

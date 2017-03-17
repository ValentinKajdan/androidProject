package com.example.valentinkajdan.firstappli;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by valentinkajdan on 15/03/2017.
 */

public class FragmentDetail extends Fragment {

    public static FragmentDetail newInstance(Post post) {
        Bundle args = new Bundle();
        args.putParcelable("post", post);

        FragmentDetail fragment = new FragmentDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.webview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebView webView = (WebView) view.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        Post post = getArguments().getParcelable("post");
        //webView.loadUrl(post.url);
       webView.loadData(post.content, "text/html; charset=utf-8", "utf-8");
    }
}

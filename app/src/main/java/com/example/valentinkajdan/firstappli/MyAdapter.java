package com.example.valentinkajdan.firstappli;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by valentinkajdan on 14/03/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private News[] news;
    private ArrayList<Post> posts;
    private OnListItemClickListener listener;

    private final int TYPE_1 = 0;
    private final int TYPE_2 = 1;

    public MyAdapter(ArrayList<Post> posts, OnListItemClickListener listener) {
        this.posts = posts;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 2 ? TYPE_2 : TYPE_1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (viewType == TYPE_1) {
            return new CardHolder(layoutInflater.inflate(R.layout.info_layout, parent, false), listener);
        } else {
            return new CardImportant(layoutInflater.inflate(R.layout.important_layout, parent, false), listener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);

        switch (itemViewType) {
            case TYPE_1:
                ((CardHolder)holder).bindValue(posts.get(position));
                break;
            case TYPE_2:
                ((CardImportant)holder).bindValue(posts.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView content;
        public TextView author;
        public ImageView imageView;
        private final OnListItemClickListener listener;

        public CardHolder(View itemView, OnListItemClickListener listener) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            author = (TextView) itemView.findViewById(R.id.author);
            imageView = (ImageView) itemView.findViewById(R.id.picassoimg);
            title.setOnClickListener(this);
            this.listener = listener;
        }

        void bindValue(Post post) {
            itemView.setTag(post);
            title.setText(post.title);
            author.setText(post.author.name + " le " + post.date);
            content.setText(Html.fromHtml(post.content).toString());
            Picasso.with(itemView.getContext())
                    .load("http://www.journaldugeek.com/wp-content/blogs.dir/1/files/2017/02/smartphone-occasion-francais-confiance.jpg")
                    .error(R.drawable.article1)
                    .placeholder(R.drawable.article2)
                    .into(imageView);
        }

        public void onClick(View v) {
            listener.onHeaderClicked((Post) itemView.getTag());
        }

    }

    public static class CardImportant extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView author;
        private final OnListItemClickListener listener;

        public CardImportant(View itemView, OnListItemClickListener l) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            title.setOnClickListener(this);
            this.listener = l;
        }

        void bindValue(Post post) {
            itemView.setTag(post);
            title.setText(post.title);
            author.setText(post.author.name + " le " + post.date);
        }

        public void onClick(View v) {
            listener.onHeaderClicked((Post) itemView.getTag());
        }


    }

}
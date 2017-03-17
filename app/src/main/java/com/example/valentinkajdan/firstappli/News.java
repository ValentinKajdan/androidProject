package com.example.valentinkajdan.firstappli;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by valentinkajdan on 14/03/2017.
 */

public class News implements Parcelable {

    public String title;
    public String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.content);
    }

    protected News(Parcel in) {
        this.title = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}

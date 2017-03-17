package com.example.valentinkajdan.firstappli;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by valentinkajdan on 17/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseLastPosts {
    public String status;
    public int count;
    public int count_total;
    public int pages;
    public ArrayList<Post> posts;
}

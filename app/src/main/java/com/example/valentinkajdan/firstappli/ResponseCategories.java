package com.example.valentinkajdan.firstappli;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by valentinkajdan on 17/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
class ResponseCategories {
    public ArrayList<Category> categories;
}

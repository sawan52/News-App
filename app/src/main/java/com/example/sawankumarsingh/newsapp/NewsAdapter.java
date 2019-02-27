package com.example.sawankumarsingh.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news){
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent,false);
        }

        News currentNews = getItem(position);

        ImageView newsImage = (ImageView)listItemView.findViewById(R.id.news_image);
        Picasso.with(getContext())
                .load(currentNews.getNewsImage())
                .into(newsImage);

        TextView newsHeading = (TextView)listItemView.findViewById(R.id.news_headline);
        newsHeading.setText(currentNews.getNewsHeadline());

        TextView newsTime = (TextView)listItemView.findViewById(R.id.news_time);
        newsTime.setText(currentNews.getNewsTime());

        return listItemView;
    }

}

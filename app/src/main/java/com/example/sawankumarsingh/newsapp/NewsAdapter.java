package com.example.sawankumarsingh.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        ImageView newsImage = listItemView.findViewById(R.id.news_image);
        Picasso.get()
                .load(currentNews.getNewsImage())
                .into(newsImage);

        TextView newsHeading = listItemView.findViewById(R.id.news_headline);
        newsHeading.setText(currentNews.getNewsHeadline());

        TextView newsDate = listItemView.findViewById(R.id.news_date);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy\nHH:mm a");
        Date date = null;
        try {
            date = inputFormat.parse(currentNews.getNewsTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = outputFormat.format(date);
        newsDate.setText(formattedDate);

        return listItemView;
    }
}

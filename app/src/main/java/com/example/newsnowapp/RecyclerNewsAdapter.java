package com.example.newsnowapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerNewsAdapter extends RecyclerView.Adapter<RecyclerNewsAdapter.RecyclerNewsViewHolder> {

    List<Article> articleList;

    public RecyclerNewsAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public RecyclerNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler_now, parent, false);
        return new RecyclerNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerNewsViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.newsTitle.setText(article.getTitle());
        holder.newsSource.setText(article.getSource().getName());
        Picasso.get().load(article.getUrlToImage())
                .error(R.drawable.no_icon_image)
                .into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    void updateData(List<Article> data){
        articleList.clear();
        articleList.addAll(data);
    }

    class RecyclerNewsViewHolder extends RecyclerView.ViewHolder{

        TextView newsTitle, newsSource;
        ImageView newsImage;

        public RecyclerNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.article_title);
            newsSource = itemView.findViewById(R.id.article_source);
            newsImage = itemView.findViewById(R.id.article_image_view);
        }
    }
}

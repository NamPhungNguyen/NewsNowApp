package com.example.newsnowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getNews();
    }

    void getNews(){
        NewsApiClient newsApiClient = new NewsApiClient("94a0d5ac7f734765827df9ef170b2ea3");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        response.getArticles().forEach(a->{
                            Log.i("Articles", a.getTitle());

                        });
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.i("Got failure", throwable.toString());
                    }
                }
        );
    }
}
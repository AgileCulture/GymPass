package com.example.jakubkurtiak.gympass;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReadNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news);

        CommonMethods.setImpactFont(ReadNewsActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ReadNewsActivity.this,R.id.read_news_header,R.string.read_news);

        setNewsContent();
    }

    private void setNewsContent() {
        TextView view = (TextView) findViewById(R.id.news_content);
        view.setText("news...");
        view.setTextColor(getResources().getColor(R.color.black));
    }
}
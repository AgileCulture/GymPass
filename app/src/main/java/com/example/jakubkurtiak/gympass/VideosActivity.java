package com.example.jakubkurtiak.gympass;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class VideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        // ***  BEFORE REMOVING THE BELOW COMMON METHODS, REMEMBER TO setImpactFont() ON THE BUTTON TEXT IN 3 METHODS BELOW
        CommonMethods.awardBadge(VideosActivity.this, R.id.badge);
        CommonMethods.setImpactFont(VideosActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(VideosActivity.this,R.id.videos,R.string.button_videos);
        CommonMethods.setImpactFont(VideosActivity.this,R.id.classes_text,R.string.classes_text);
        CommonMethods.setImpactFont(VideosActivity.this,R.id.classes_bottom_text,R.string.classes_bottom);

    }

    protected void playClassesVideo1(View view){
        playVideo("https://www.youtube.com/watch?v=1drXLfIT7p8");
    }

    protected void playClassesVideo2(View view){
        playVideo("https://www.youtube.com/watch?v=44861zB1Bao");
    }

    protected void playClassesVideo3(View view){
        playVideo("https://www.youtube.com/watch?v=vtIQcIMr7iM");
    }


    /* Youtube link to UCD Induction video  - comment left by Shane
         https://www.youtube.com/watch?v=FRfmw3jw2c4
     */


    // Simple intent to play YouTube video after clicking on an image/button.
    protected void playVideo(String video) {
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(video)));
    }
}
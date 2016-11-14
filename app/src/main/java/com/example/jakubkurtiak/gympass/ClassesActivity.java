package com.example.jakubkurtiak.gympass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClassesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

     //   CommonMethods.setImpactFont(ClassesActivity.this,R.id.top,R.string.gympass);
        //  CommonMethods.setImpactFont(ClassesActivity.this,R.id.classes_header,R.string.share_now);

      //  setShareContent();
    }

    private void setShareContent() {
      //  TextView view = (TextView) findViewById(R.id.classes_content);
        CommonMethods.setImpactFont(ClassesActivity.this, R.id.top, R.string.class_bookings);
      //  view.setTextColor(getResources().getColor(R.color.black));
    }


    public void shareStatus(View v) {
        String msgToShare = "I'm one of those vain pricks who checks-in on FB whenever I go to the gym  - sent from GymPass";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, msgToShare);
        startActivity(Intent.createChooser(shareIntent,"Choose an app from the list:"));
    }
}

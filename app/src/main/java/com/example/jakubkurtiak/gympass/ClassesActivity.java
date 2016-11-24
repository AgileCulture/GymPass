package com.example.jakubkurtiak.gympass;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.Button;


public class ClassesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        // ***  BEFORE REMOVING THE BELOW COMMON METHODS, REMEMBER TO setImpactFont() ON THE BUTTON TEXT IN 3 METHODS BELOW
        CommonMethods.setImpactFont(ClassesActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ClassesActivity.this,R.id.classes,R.string.classes_header);
        CommonMethods.setImpactFont(ClassesActivity.this,R.id.classes_text,R.string.classes_text);
    }




    public void shareAll(View view) {
        Intent shareAllIntent = new Intent(Intent.ACTION_SEND);
        shareAllIntent.setType("text/plain");

        String msgToShareAll = "In here will go a message that shows all of the sessions I've done over the time since app use started";
        shareAllIntent.putExtra(Intent.EXTRA_TEXT, msgToShareAll);
        startActivity(Intent.createChooser(shareAllIntent, "Choose an app or conversation from the list to share to"));

        //https://www.youtube.com/embed/1drXLfIT7p8

        //

    }



}
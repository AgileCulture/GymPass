package com.example.jakubkurtiak.gympass;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReadNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news);

        CommonMethods.setImpactFont(ReadNewsActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ReadNewsActivity.this,R.id.read_news_header,R.string.read_news);

        setImpactFont(R.id.top,R.string.gympass);
        setImpactFont(R.id.read_news_header,R.string.read_news);

        setNewsContent();
    }

    private void setNewsContent() {
        TextView view = (TextView) findViewById(R.id.news_content);
        view.setText("Latest News:  "+readGymLocation());
        view.setTextColor(getResources().getColor(R.color.black));
    }


    protected String readGymLocation() {
        String tableNews = "tbGymPassNew";
        String gymLoc = "";
        String gymLoc2 = "";


        Cursor cursorGymPass = openGymPassDatabase(null).rawQuery("SELECT * FROM " + tableNews, null);
        int indexLocation = cursorGymPass.getColumnIndex("news_header");
        int indexLocation2 = cursorGymPass.getColumnIndex("news_content");

        cursorGymPass.moveToLast();

        gymLoc = cursorGymPass.getString(indexLocation);
        gymLoc2 = cursorGymPass.getString(indexLocation2);

        cursorGymPass.close();
        return gymLoc + " \n \n \n" + gymLoc2;
    }


    protected SQLiteDatabase openGymPassDatabase (SQLiteDatabase db) {
        try {
            db = openOrCreateDatabase("sqlGymPass", MODE_PRIVATE, null);
        } catch (Exception e) {
            Log.e("DB_read_error", "Database read error");
        }
        return db;
    }

    // Set Impact font for given view and string.
    protected void setImpactFont(int viewName, int theString) {
        TextView newfont = (TextView) findViewById(viewName);
        Typeface font=Typeface.createFromAsset(getAssets(), "fonts/impact.ttf");
        newfont.setText(theString);
        newfont.setTypeface(font, Typeface.ITALIC);
    }
}
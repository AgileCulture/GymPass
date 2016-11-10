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
        view.setText("  \n "+readGymLocation());
        view.setTextColor(getResources().getColor(R.color.black));
    }

    private void setNewsContent2() {
        TextView view = (TextView) findViewById(R.id.news_content);
        view.setText("  \n "+readGymLocation());
        view.setTextColor(getResources().getColor(R.color.black));
    }

    protected void onResume() {

        super.onResume();
        setContentView(R.layout.activity_read_news);

        setImpactFont(R.id.top,R.string.gympass);
        setImpactFont(R.id.read_news_header,R.string.read_news);

        setNewsContent2();
    }

    protected String readGymLocation() {
        String tableNews = "tbGymPassNews";
        String gymN = "";
        String gymN2 = "";



        Cursor cursorGymPass = openGymPassDatabase(null).rawQuery("SELECT * FROM " + tableNews, null);
        int indexNews = cursorGymPass.getColumnIndex("news_header");
        int indexNews2 = cursorGymPass.getColumnIndex("news_content");

        cursorGymPass.moveToFirst();

        gymN = cursorGymPass.getString(indexNews);
        gymN2 = cursorGymPass.getString(indexNews2);

        cursorGymPass.close();
        return gymN + " \n \n \n" + gymN2;
    }

    protected String readGymLocation2() {
        String tableNews = "tbGymPassNews";
        String gymN = "";
        String gymN2 = "";



        Cursor cursorGymPass = openGymPassDatabase(null).rawQuery("SELECT * FROM " + tableNews, null);
        int indexNews = cursorGymPass.getColumnIndex("news_header");
        int indexNews2 = cursorGymPass.getColumnIndex("news_content");

        cursorGymPass.moveToLast();

        gymN = cursorGymPass.getString(indexNews);
        gymN2 = cursorGymPass.getString(indexNews2);

        cursorGymPass.close();
        return gymN + " \n \n \n" + gymN2;
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
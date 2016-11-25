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

        //Logo and text font displayed
        CommonMethods.setImpactFont(ReadNewsActivity.this, R.id.top, R.string.gympass);
        CommonMethods.setImpactFont(ReadNewsActivity.this, R.id.read_news_header, R.string.read_news);
        CommonMethods.setImpactFont(ReadNewsActivity.this, R.id.news_content, R.string.read_news);


       // TextView view = (TextView) findViewById(R.id.news_content);
        setNewsContent0();



    }
    //testing part 2
    //final String[] myName = {test, test1, test2};



    //String test = setNewsContent0();
    //String test1 = setNewsContent1();
    //String test2 = setNewsContent2();
    //final String[] myName = {test, test1, test2};

    //This method displays random text from the database
    private String setNewsContent0() {
        TextView view = (TextView) findViewById(R.id.news_content);

        //Each method stored within array
        final String[] newsArray = {readGymNews0(), readGymNews1(), readGymNews2()};
        //random is assigned to randomNews
        int randomNews = (int) ((Math.random() * 3));
        //Array which was created and random bought assigned to string newsTo Show, to be called on view
        String newsToShow = newsArray[randomNews];

//        view.setText("\n \n  " + readGymLocation0() +"\n \n \n                     "
//                +readGymLocation1()+"\n \n \n                 "
//                + readGymLocation2());
//        view.setTextColor(getResources().getColor(R.color.black));

        //View call
        view.setText("\n \n" + newsToShow);
        //view.setTextColor(getResources().getColor(R.color.black));

        return null;
    }


    //Retrieving the data from the database on mainActivity page
    protected String readGymNews0() {
        String tableNews = "tbGymPassNews";
        String gymN = "";
        String gymN2 = "";


        //Selecting which data its retrieving
        Cursor cursorGymPass = openGymPassDatabase(null).rawQuery("SELECT * FROM " + tableNews, null);
        int indexNews = cursorGymPass.getColumnIndex("news_header");
        int indexNews2 = cursorGymPass.getColumnIndex("news_content");

        //Location of the data its retrieving for the database
        cursorGymPass.moveToPosition(2);

        //Assigning the news values
        gymN = cursorGymPass.getString(indexNews);
        gymN2 = cursorGymPass.getString(indexNews2);

        //Close and returning the data
        cursorGymPass.close();
        return gymN + " \n \n \n" + gymN2;
    }

    //Retrieving the data from the database on mainActivity page
    protected String readGymNews1() {
        String tableNews = "tbGymPassNews";
        String gymN = "";
        String gymN2 = "";


        //Selecting which data its retrieving
        Cursor cursorGymPass = openGymPassDatabase(null).rawQuery("SELECT * FROM " + tableNews, null);
        int indexNews = cursorGymPass.getColumnIndex("news_header");
        int indexNews2 = cursorGymPass.getColumnIndex("news_content");

        //Location of the data its retrieving for the database
        cursorGymPass.moveToPosition(1);

        //Assigning the news values
        gymN = cursorGymPass.getString(indexNews);
        gymN2 = cursorGymPass.getString(indexNews2);

        //Close and returning the data
        cursorGymPass.close();
        return gymN + " \n \n \n" + gymN2;

    }


    //Retrieving the data from the database on mainActivity page
    protected String readGymNews2() {
        String tableNews = "tbGymPassNews";
        String gymN = "";
        String gymN2 = "";


        //Selecting which data its retrieving
        Cursor cursorGymPass = openGymPassDatabase(null).rawQuery("SELECT * FROM " + tableNews, null);
        int indexNews = cursorGymPass.getColumnIndex("news_header");
        int indexNews2 = cursorGymPass.getColumnIndex("news_content");

        //Location of the data its retrieving for the database
        cursorGymPass.moveToPosition(0);

        //Assigning the news values
        gymN = cursorGymPass.getString(indexNews);
        gymN2 = cursorGymPass.getString(indexNews2);

        //Close and returning the data
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


}


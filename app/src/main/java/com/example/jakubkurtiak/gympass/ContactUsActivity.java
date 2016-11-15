package com.example.jakubkurtiak.gympass;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;




public class ContactUsActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    ImageButton callButton, mapButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);



        CommonMethods.setImpactFont(ContactUsActivity.this, R.id.top, R.string.gympass);
        CommonMethods.setImpactFont(ContactUsActivity.this, R.id.contact_us_header, R.string.contact_us_header);

        setContactContent();
    }

    private void setContactContent() {
        TextView view = (TextView) findViewById(R.id.news_content);
        view.setText("contact...");
        view.setTextColor(getResources().getColor(R.color.black));

        mapButton = (ImageButton) findViewById(R.id.imageButtonMap);




            //https://www.tutorialspoint.com/android/android_phone_calls.htm

        //id button gets assigned to callButton variable
        callButton = (ImageButton) findViewById(R.id.buttonCall);

        callButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {

                //built-in phone call function (Action call)
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                //sets  a specific phone number
                callIntent.setData(Uri.parse("tel:+353857357713"));

                if (ActivityCompat.checkSelfPermission(ContactUsActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }
    //mapButton.setOnClickListener(new View.OnClickListener() {


        public void onClickMap (View view){

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.ie/maps/place/UCD+Sport+and+Fitness/@53.3081152,-6.2303547,17z/data=!4m5!3m4!1s0x4867093667320733:0x792c4381232c6b96!8m2!3d53.308112!4d-6.228166"));
            startActivity(intent);

        }

    }







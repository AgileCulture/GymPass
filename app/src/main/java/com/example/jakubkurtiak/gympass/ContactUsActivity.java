package com.example.jakubkurtiak.gympass;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class ContactUsActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    ImageButton callButton, mapButton, emailButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        CommonMethods.setImpactFont(ContactUsActivity.this, R.id.top, R.string.gympass);
        CommonMethods.setImpactFont(ContactUsActivity.this, R.id.contact_us_header, R.string.contact_us_header);
        CommonMethods.setImpactFont(ContactUsActivity.this, R.id.news_content, R.string.gym_address);

        setContactContent();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void setContactContent() {
        TextView view = (TextView) findViewById(R.id.news_content);
        view.setText(R.string.gym_address);
        //view.setTextColor(getResources().getColor(R.color.black));


        mapButton = (ImageButton) findViewById(R.id.imageButtonMap);



            //https://www.tutorialspoint.com/android/android_phone_calls.htm
        //https://www.tutorialspoint.com/android/android_phone_calls.htm

        //id button gets assigned to callButton variable
        callButton = (ImageButton) findViewById(R.id.buttonCall);

        callButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {

                //built-in phone call function (Action call)
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                //sets  a specific phone number
                callIntent.setData(Uri.parse("tel:(01)7163800"));

                if (ActivityCompat.checkSelfPermission(ContactUsActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
    }
    //mapButton.setOnClickListener(new View.OnClickListener() {


    //`Loads the maps action
    public void onClickMap(View view) {

        //launches the map intent with the set Uri location
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.ie/maps/place/UCD+Sport+and+Fitness/@53.3081152,-6.2303547,17z/data=!4m5!3m4!1s0x4867093667320733:0x792c4381232c6b96!8m2!3d53.308112!4d-6.228166"));
        startActivity(intent);

    }


    //Lunches the code below after images button pressed
    public void onClickEmail(View View) {


        //launches the email which is stored on our phone
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        //Email address to receiver
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{" fitness@ucd.ie"});
        //Holds the subject of the emails
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Gym Query");
        //Holds the subject of the email messsage
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi ");
        //set the action send to data type emails
        emailIntent.setType("message/rfc822");
        startActivity(emailIntent);


    }


}







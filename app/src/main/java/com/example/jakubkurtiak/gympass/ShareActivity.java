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


public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        // ***  BEFORE REMOVING THE BELOW COMMON METHODS, REMEMBER TO setImpactFont() ON THE BUTTON TEXT IN 3 METHODS BELOW
        CommonMethods.setImpactFont(ShareActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.share_now,R.string.share_now);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.button,R.string.button);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.button2,R.string.button2);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.button3,R.string.button3);
    }


    public void shareStatus(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        String msgToShare = "I'm one of those vain pricks who checks-in on FB whenever I go to the gym  - sent from GymPass";
        shareIntent.putExtra(Intent.EXTRA_TEXT, msgToShare);
        startActivity(Intent.createChooser(shareIntent,"Choose an app or conversation from the list:"));

        //  Need to make the CommonMethods.setImpactFont usable from the CommonMethods class, or else make another setFont common method
        //  that doesn't need to take in all 3 arguments of Activity, View and Message
        //      CommonMethods.setImpactFont(ShareActivity.this, view, R.string.share_to_app)
    }


    public void shareUpdate(View view) {
//        Intent shareIntent = new Intent(Intent.ACTION_SEND);
//        shareIntent.setType("text/plain");
//
//        String msgToShare = "In here will go an update: I have been at the gym X times in the past Y days/weeks/months";
//        shareIntent.putExtra(Intent.EXTRA_TEXT, msgToShare);
//        startActivity(Intent.createChooser(shareIntent,"Choose an app or conversation from the list:"));

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=FRfmw3jw2c4")));


    }

    public void shareAll(View view) {
        Intent shareAllIntent = new Intent(Intent.ACTION_SEND);
        shareAllIntent.setType("text/plain");

        String msgToShareAll = "In here will go a message that shows all of the sessions I've done over the time since app use started";
        shareAllIntent.putExtra(Intent.EXTRA_TEXT, msgToShareAll);
        startActivity(Intent.createChooser(shareAllIntent, "Choose an app or conversation from the list to share to"));
    }

}
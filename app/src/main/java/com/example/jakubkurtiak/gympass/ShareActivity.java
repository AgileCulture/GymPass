package com.example.jakubkurtiak.gympass;

        import android.graphics.Typeface;
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

        CommonMethods.setImpactFont(ShareActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.top,R.string.share_now);


        setShareContent();

    }



    private void setShareContent() {
//        final TextView view = (TextView) findViewById(R.id.this);
        final Button shareButton = new Button(this);
        shareButton.setTextColor(getResources().getColor(R.color.darkturquoise));
        shareButton.setText("Click here if you think other people give a shit...");
        setContentView(shareButton);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgToShare = "I'm one of those vain pricks who checks-in on FB whenever I go to the gym  - sent from GymPass";
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, msgToShare);
                startActivity(Intent.createChooser(shareIntent,"Choose an app from the list:"));
            }
        });


    }

}
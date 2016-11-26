package com.example.jakubkurtiak.gympass;

        import android.app.Activity;
        import android.database.Cursor;
        import android.graphics.Typeface;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;
        import android.content.Intent;
        import android.text.Html;
        import android.view.View;
        import android.widget.Button;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.HashMap;
        import java.util.Hashtable;


public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);


        CommonMethods.setImpactFont(ShareActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.share_now,R.string.share_now);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.button,R.string.button);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.button2,R.string.button2);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.button3,R.string.button3);
    }

    private String getChooseAppString() {
        return getString(R.string.share_to_app);

    }


    public void shareStatus(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        String msgToShare = "Working out at the gym - sent from GymPass";
        shareIntent.putExtra(Intent.EXTRA_TEXT, msgToShare);
        startActivity(Intent.createChooser(shareIntent, getChooseAppString()));
    }

    public void shareUpdate(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        // CommonMethods.timeSinceLastVisit(ShareActivity.this);

        String msgToShare = "In here will go an update: I have been at the gym X times in the past Y days/weeks/months";
        shareIntent.putExtra(Intent.EXTRA_TEXT, msgToShare);
        startActivity(Intent.createChooser(shareIntent, getChooseAppString()));
    }


    public void shareAll(View view) {
        Intent shareAllIntent = new Intent(Intent.ACTION_SEND);
        shareAllIntent.setType("text/plain");
        int totalVisits = CommonMethods.readNumberOfVisits(ShareActivity.this);
        String durationSinceFirstSession = periodSinceFirstVisit(ShareActivity.this);
        String sessions;
        sessions = (totalVisits == 1) ? "session" : "sessions";

        String msgToShareAll = "I've done a total of " + totalVisits + " " + sessions + " since I started my programme " + durationSinceFirstSession + " ago!";
        shareAllIntent.putExtra(Intent.EXTRA_TEXT, msgToShareAll);
        startActivity(Intent.createChooser(shareAllIntent, getChooseAppString()));
    }


    // Customised DB methods, with accessibility to the methods set as: private to this Class

    private static String periodSinceFirstVisit(Activity activity) {
        // Get the time of last visit and compare to current time.

        Cursor cursorNoVisits = CommonMethods.readTableToCursor(activity, "tbGymPassCustomerVisits");
        cursorNoVisits.moveToFirst();

        int indexTime = cursorNoVisits.getColumnIndex("timestamp");
        String time = cursorNoVisits.getString(indexTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Date dateOfFirstVisit = null;
        try {
            dateOfFirstVisit = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cursorNoVisits.close();

        // To calculate the difference between NOW and LAST VISIT, Date must be changed
        // into long. Then time of last visit is subtracted from actual time which
        // gives us the actual time since last visit.
        // This time is in seconds, so must be changed to human readable format.
        long dateTimeNowInSeconds = new Date().getTime()/1000;
        long dateTimeFirstVisitInSeconds = dateOfFirstVisit.getTime()/1000;
        long timeSinceLastVisitInSeconds = dateTimeNowInSeconds - dateTimeFirstVisitInSeconds;
        int daysSinceFirstVisit = (int) (timeSinceLastVisitInSeconds / 86400);

        // Returns a String of how long since user's first gym session, formatted in days or weeks.
        String formattedPeriodSinceFirstVisit;

            if (daysSinceFirstVisit == 1) {
                formattedPeriodSinceFirstVisit = "1 day";
            }
            else if (daysSinceFirstVisit < 7) {
                formattedPeriodSinceFirstVisit = daysSinceFirstVisit + " days";
            }
            else if (daysSinceFirstVisit == 7) {
                formattedPeriodSinceFirstVisit = "1 week";
            }
            else {
                int weeksSinceFirstVisit = daysSinceFirstVisit / 7;
                formattedPeriodSinceFirstVisit = weeksSinceFirstVisit + " weeks";
            }

        return formattedPeriodSinceFirstVisit;
    }


}
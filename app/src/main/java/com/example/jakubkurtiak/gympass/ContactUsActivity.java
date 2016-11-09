package com.example.jakubkurtiak.gympass;

        import android.graphics.Typeface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class ContactUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        CommonMethods.setImpactFont(ContactUsActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ContactUsActivity.this,R.id.contact_us_header,R.string.contact_us_header);

        setContactContent();
    }

    private void setContactContent() {
        TextView view = (TextView) findViewById(R.id.news_content);
        view.setText("contact...");
        view.setTextColor(getResources().getColor(R.color.black));
    }
}
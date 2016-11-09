package com.example.jakubkurtiak.gympass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ClassesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        CommonMethods.setImpactFont(ClassesActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ClassesActivity.this,R.id.classes_header,R.string.share_now);

        setShareContent();
    }

    private void setShareContent() {
        TextView view = (TextView) findViewById(R.id.classes_content);
        CommonMethods.setImpactFont(ClassesActivity.this, R.id.buttonShare, R.string.class_bookings);
        view.setTextColor(getResources().getColor(R.color.black));
    }
}

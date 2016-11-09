package com.example.jakubkurtiak.gympass;

        import android.graphics.Typeface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        CommonMethods.setImpactFont(ShareActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(ShareActivity.this,R.id.share_header,R.string.share_now);

        setShareContent();
    }

    private void setShareContent() {
        TextView view = (TextView) findViewById(R.id.share_content);
        view.setText("Shane's change - this is my second change");
        view.setTextColor(getResources().getColor(R.color.black));
        //mick change
    }
}
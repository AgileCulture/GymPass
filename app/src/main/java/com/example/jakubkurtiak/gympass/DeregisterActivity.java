package com.example.jakubkurtiak.gympass;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.graphics.Typeface;
        import android.os.Handler;
        import android.preference.PreferenceManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.Toast;

public class DeregisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deregister);

        CommonMethods.setImpactFont(DeregisterActivity.this,R.id.top,R.string.gympass);
        CommonMethods.setImpactFont(DeregisterActivity.this,R.id.deregister_header,R.string.deregister);
        CommonMethods.setImpactFont(DeregisterActivity.this,R.id.buttonDeregisterNow,R.string.button_deregister);

        setAreYouSure();
        setDeregisterContent();
    }

    @Override
    public void onResume() {
        super.onResume();
        CommonMethods.isAppRegistered(DeregisterActivity.this);
    }

    // Click to Deregister
    protected void clickDeregisterNow(View view) {

        // This is simply deleting whole database, which seems to be the best approach as it not
        // only deletes login details but their visits data and everything that was stored so far.
        // Once deleted, move to initial screen.

        try {
            getBaseContext().deleteDatabase("sqlGymPass");
        } catch (Exception e) {
            Log.e("DEREGISTER_DB_DEL_ERR", "Cannot delete database");
        }

        Toast.makeText(DeregisterActivity.this,"Deregistered",Toast.LENGTH_SHORT).show();

        Intent moveToMainActivity = new Intent(DeregisterActivity.this, MainActivity.class);
        startActivity(moveToMainActivity);
        DeregisterActivity.this.finish();

    }

    private void setAreYouSure() {

        // Using login name from SharedPreferences to address user.
        TextView view = (TextView) findViewById(R.id.are_you_sure);
        view.setText(
            getString(R.string.deregister_are_you_sure,CommonMethods.returnCurrentLogin(DeregisterActivity.this))
        );
        view.setTextColor(getResources().getColor(R.color.black));
    }

    private void setDeregisterContent() {
        TextView view = (TextView) findViewById(R.id.deregister_content);
        view.setText(R.string.deregister_message);
        view.setTextColor(getResources().getColor(R.color.black));
    }
}


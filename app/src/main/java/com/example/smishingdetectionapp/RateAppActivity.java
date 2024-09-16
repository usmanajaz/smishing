package com.example.smishingdetectionapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.smishingdetectionapp.R; // Replace 'yourappname' with your actual package name

public class RateAppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_rate_app);

        Button rateNowButton = findViewById(R.id.rate_now_button);
        Button rateLaterButton = findViewById(R.id.rate_later_button);

        // Rate Now button click event
        rateNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayStore();
            }
        });

        // Remind Me Later button click event
        rateLaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismissRatingPrompt();
            }
        });
    }

    private void openPlayStore() {
        final String appPackageName = getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    private void dismissRatingPrompt() {
        finish(); // Close the popup
    }
}

package com.parita.mentalhealthapp;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class ScreenshotDetectionActivity extends AppCompatActivity implements ScreenshotDetectionDelegate.ScreenshotDetectionListener {

    private ScreenshotDetectionDelegate screenshotDetectionDelegate = new ScreenshotDetectionDelegate(this, this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        screenshotDetectionDelegate.startScreenshotDetection();
    }

    @Override
    protected void onStop() {
        super.onStop();
        screenshotDetectionDelegate.stopScreenshotDetection();
    }

    public void stopScreenShotDetect() {
        screenshotDetectionDelegate.stopScreenshotDetection();
    }

    @Override
    public void onScreenCaptured(String path) {
        // Do something when screen was captured
    }
}



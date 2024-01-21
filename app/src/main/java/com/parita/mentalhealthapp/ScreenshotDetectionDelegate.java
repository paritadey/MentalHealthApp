package com.parita.mentalhealthapp;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;

import java.lang.ref.WeakReference;

class ScreenshotDetectionDelegate {
    private WeakReference<Activity> activityWeakReference;
    private ScreenshotDetectionListener listener;

    public ScreenshotDetectionDelegate(Activity activityWeakReference, ScreenshotDetectionListener listener) {
        this.activityWeakReference = new WeakReference<>(activityWeakReference);
        this.listener = listener;
    }

    public void startScreenshotDetection() {
        activityWeakReference.get()
                .getContentResolver()
                .registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, contentObserver);
    }

    public void stopScreenshotDetection() {
        activityWeakReference.get().getContentResolver().unregisterContentObserver(contentObserver);
    }

    private ContentObserver contentObserver = new ContentObserver(new Handler()) {

        @Override
        public boolean deliverSelfNotifications() {return super.deliverSelfNotifications();}

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            String path = getFilePathFromContentResolver(activityWeakReference.get(), uri);
            if (isScreenshotPath(path)) {
                onScreenCaptured(path);
            }
        }
    };


    private void onScreenCaptured(String path) {
        if (listener != null) {
            listener.onScreenCaptured(path);
        }
    }

    private boolean isScreenshotPath(String path) {
        return path != null && path.toLowerCase().contains("screenshots");
    }

    private String getFilePathFromContentResolver(Context context, Uri uri) {
        String filePath = null;
        String[] projection = {MediaStore.Images.Media.DATA};
        try {
            // Use a ContentResolver to query the media file with the specified content URI
            Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                filePath = cursor.getString(columnIndex);
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public interface ScreenshotDetectionListener {
        void onScreenCaptured(String path);
    }
}

package com.example.timeconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[HWDBG]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);

        String buildTime = null;
        buildTime = convertTime("Thu Feb 13 17:21:10 CST 2020",
                    "EEE MMM dd HH:mm:ss 'CST' yyyy",
                    "dd/MM/yyyy-HH:mm:ss");
        textView.setText(buildTime);
    }

    private String convertTime(String timeString, String originalPattern, String newPattern) {

        String buildTime = null;

        if (null == timeString || null == originalPattern || null == newPattern) {
            Log.d(TAG, "The input string is invalid!");
            return null;
        }

        try {
            SimpleDateFormat isoFormat1 = new SimpleDateFormat(
                    originalPattern,
                    Locale.ENGLISH);
            SimpleDateFormat isoFormat2 = new SimpleDateFormat(
                    newPattern,
                    Locale.ENGLISH);
            Date date = isoFormat1.parse(timeString);
            if (null != date) {
                buildTime = isoFormat2.format(date);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return buildTime;
    }
}

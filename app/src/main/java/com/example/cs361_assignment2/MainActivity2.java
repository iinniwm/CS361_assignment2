package com.example.cs361_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity2 extends AppCompatActivity {

    String filename = "cs361.txt";
    ArrayList<String> sales = new ArrayList<String>();
    ArrayList<String> percent = new ArrayList<String>();
    ArrayList<String> Deduct = new ArrayList<String>();
    ArrayList<String> sharesale = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String inputString;
        String[] s;
        try {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
            StringBuffer stringBuffer = new StringBuffer();
            while ((inputString = inputReader.readLine()) != null) {
                s = inputString.split(":");
                sales.add(s[0]);
                percent.add(s[1]);
                Deduct.add(s[2]);
                sharesale.add(s[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.reverse(sales);
        Collections.reverse(percent);
        Collections.reverse(Deduct);
        Collections.reverse(sharesale);

        final TextView txt1=(TextView)findViewById(R.id.textView17);
        final TextView txt2=(TextView)findViewById(R.id.textView18);
        final TextView txt3=(TextView)findViewById(R.id.textView19);
        final TextView txt4=(TextView)findViewById(R.id.textView20);

        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";

        for (String i : sales) {
            s1 += i+"\n";
        }

        for (String i : percent) {
            s2 += i+"\n";
        }

        for (String i : Deduct) {
            s3 += i+"\n";
        }

        for (String i : sharesale) {
            s4 += i+"\n";
        }

        txt1.setText(s1);
        txt2.setText(s2);
        txt3.setText(s3);
        txt4.setText(s4);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txt1=(TextView)findViewById(R.id.textView11);
        final TextView txt2=(TextView)findViewById(R.id.textView22);
        final TextView txt3=(TextView)findViewById(R.id.textView23);
        final TextView txt4=(TextView)findViewById(R.id.textView24);
        final TextView txt5=(TextView)findViewById(R.id.textView25);
        final TextView txt6=(TextView)findViewById(R.id.textView17);
        final TextView txt7=(TextView)findViewById(R.id.textView18);
        final TextView txt8=(TextView)findViewById(R.id.textView19);
        final TextView txt9=(TextView)findViewById(R.id.textView20);

        txt1.setTextSize(newConfig.fontScale*13);
        txt2.setTextSize(newConfig.fontScale*13);
        txt3.setTextSize(newConfig.fontScale*13);
        txt4.setTextSize(newConfig.fontScale*13);
        txt5.setTextSize(newConfig.fontScale*13);
        txt6.setTextSize(newConfig.fontScale*13);
        txt7.setTextSize(newConfig.fontScale*13);
        txt8.setTextSize(newConfig.fontScale*13);
        txt9.setTextSize(newConfig.fontScale*13);
    }
}

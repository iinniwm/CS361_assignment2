package com.example.cs361_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText x1;
    EditText x2;
    EditText x3;
    EditText x4;
    DecimalFormat formatter = new DecimalFormat("#,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x1 = (EditText)findViewById(R.id.editTextNumberDecimal);
        x1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});

        x2 = (EditText)findViewById(R.id.editTextNumberDecimal2);
        x2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(8, 2)});

        x3 = (EditText)findViewById(R.id.editTextNumberDecimal3);
        x4 = (EditText)findViewById(R.id.editTextNumberDecimal4);
    }

    public void cal(View v){
        String sales = x1.getText().toString();
        String Share_percentage = x2.getText().toString();

        Float m = Float.parseFloat(sales);
        Float ma = Float.parseFloat(Share_percentage);

        Float Share_deduct = m * (ma/100);
        Float Share_sales = m-Share_deduct;

        String x5 = String.valueOf(formatter.format(Float.parseFloat(String.valueOf(Share_deduct))));
        String x6 = String.valueOf(formatter.format(Float.parseFloat(String.valueOf(Share_sales))));
        sales =formatter.format(Float.parseFloat(sales));

        String abc = sales+":"+Share_percentage+":"+x6+":"+x5+"\n";

        writefile(abc);

        x3.setText(x6);
        x4.setText(x5);
    }

    public void writefile(String s){
        String filename = "cs361.txt";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, MODE_APPEND);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showhistory(View view){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView txt1=(TextView)findViewById(R.id.textView2);
        final TextView txt2=(TextView)findViewById(R.id.textView3);
        final TextView txt3=(TextView)findViewById(R.id.textView4);
        final TextView txt4=(TextView)findViewById(R.id.textView5);
        final TextView txt5=(TextView)findViewById(R.id.textView6);

        txt1.setTextSize(newConfig.fontScale*14);
        txt2.setTextSize(newConfig.fontScale*14);
        txt3.setTextSize(newConfig.fontScale*14);
        txt4.setTextSize(newConfig.fontScale*14);
        txt5.setTextSize(newConfig.fontScale*14);
    }
}

    class DecimalDigitsInputFilter implements InputFilter {
    private Pattern mPattern;
    DecimalDigitsInputFilter(int digits, int digitsAfterZero) {
        mPattern = Pattern.compile("[0-9]{0," + (digits - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) +
                "})?)||(\\.)?");
    }
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Matcher matcher = mPattern.matcher(dest);
        if (!matcher.matches())
            return "";
        return null;
    }
}
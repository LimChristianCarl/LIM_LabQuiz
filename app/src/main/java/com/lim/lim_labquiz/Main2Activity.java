package com.lim.lim_labquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    TextView tvAuthor, tvQuote;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvAuthor = (TextView) findViewById(R.id.text_Author);
        tvQuote = (TextView) findViewById(R.id.text_Quote);

        StringBuffer buffer = new StringBuffer();
        int read = 0;

        try{
            fis = openFileInput("author.txt");
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }

            tvAuthor.setText(buffer.toString() + " said,");

            fis.close();

            fis = openFileInput("quote.txt");
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }

            tvQuote.setText("\"" + buffer.toString() + "\"" );

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}

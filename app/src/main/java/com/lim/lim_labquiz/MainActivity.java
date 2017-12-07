package com.lim.lim_labquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etAuthor, etQuote;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor = (EditText) findViewById(R.id.et_Author);
        etQuote = (EditText) findViewById(R.id.et_Quote);
    }

    public void InternalStorage(View view) {

        String author = etAuthor.getText().toString();
        String quote = etQuote.getText().toString();

        try{
            fos = openFileOutput("author.txt", Context.MODE_PRIVATE);
            fos.write(author.getBytes());

            fos = openFileOutput("quote.txt", Context.MODE_PRIVATE);
            fos.write(quote.getBytes());

            Toast.makeText(this, "Saved in Internal Storage!", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Next(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}

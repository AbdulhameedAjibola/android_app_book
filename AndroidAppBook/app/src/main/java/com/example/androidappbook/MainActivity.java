package com.example.androidappbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button freeBook = findViewById(R.id.freeBook); // Reference to your button
        Button paidBook = findViewById(R.id.paidBook);


        freeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FreeBooks.class);
                startActivity(intent);

            }
        });

        paidBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaidBooks.class);
                startActivity(intent);
            }
        });





    }
}
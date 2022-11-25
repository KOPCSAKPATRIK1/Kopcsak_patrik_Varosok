package com.example.kopcsak_patrik_varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button listButton;
    private Button insertButton;

    public static String BASE_URL = "https://retoolapi.dev/QOVoYu/varosok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });
    }

    private void init()
    {
        listButton = findViewById(R.id.listButton);
        insertButton = findViewById(R.id.insertButton);
    }



}
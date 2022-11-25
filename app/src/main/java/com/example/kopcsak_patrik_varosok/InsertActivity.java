package com.example.kopcsak_patrik_varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

public class InsertActivity extends AppCompatActivity {
    private Button backButton;
    private Button addButton;
    private EditText nameText;
    private EditText countryText;
    private EditText populationText;
    private String BASE_URL = "https://retoolapi.dev/QOVoYu/varosok";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(InsertActivity.this, MainActivity.class);
                InsertActivity.this.startActivity(myIntent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addVaros();
            }
        });
    }

    public void init(){
        backButton = findViewById(R.id.insertBackButton);
        addButton = findViewById(R.id.addButton);
        nameText = findViewById(R.id.nameText);
        countryText = findViewById(R.id.countryText);
        populationText = findViewById(R.id.populationText);
    }

    private void addVaros() {
        String name = nameText.getText().toString();
        String country = countryText.getText().toString();
        String population = populationText.getText().toString();

        boolean valid = validation();

        if (valid){
            Toast.makeText(this,
                    "Mindent ki kell tolteni", Toast.LENGTH_SHORT).show();
            return;
        }

        int populationInt = Integer.parseInt(population);
        City city = new City(0,name,country,populationInt);
        Gson jsonConverter = new Gson();
        RequestTask task = new RequestTask(BASE_URL, "POST",
                jsonConverter.toJson(city));
        task.execute();
    }

    private boolean validation() {
        if (nameText.getText().toString().isEmpty() ||
                countryText.getText().toString().isEmpty() || populationText.getText().toString().isEmpty())
            return true;
        else
            return false;
    }

    private class RequestTask extends AsyncTask<Void, Void, Response> {
        private String requestUrl;
        private String requestMethod;
        private String requestBody;

        public RequestTask(String requestUrl) {
            this.requestUrl = requestUrl;
            this.requestMethod = "GET";
        }

        public RequestTask(String requestUrl, String requestMethod) {
            this.requestUrl = requestUrl;
            this.requestMethod = requestMethod;
        }

        public RequestTask(String requestUrl, String requestMethod, String requestBody) {
            this.requestUrl = requestUrl;
            this.requestMethod = requestMethod;
            this.requestBody = requestBody;
        }

        @Override
        protected Response doInBackground(Void... voids) {
            Response response = null;
            try {
                switch (requestMethod) {
                    case "GET":
                        response = RequestHandler.get(BASE_URL);
                        break;
                    case "POST":
                        response = RequestHandler.post(requestUrl, requestBody);
                        break;
                    case "PUT":
                        response = RequestHandler.put(requestUrl, requestBody);
                        break;
                    case "DELETE":
                        response = RequestHandler.delete(requestUrl);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }
}
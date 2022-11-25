package com.example.kopcsak_patrik_varosok;

import android.annotation.SuppressLint;

import com.google.gson.annotations.Expose;

public class City {
    private int id;
    @Expose
    private String name;
    @Expose
    private String country;
    @Expose
    private int population;

    public City(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.country = email;
        this.population = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getAgeText() {
        return String.valueOf(this.population);
    }

    public void setAgeText(String ageText) {
        if (ageText.equals("")) {
            this.population = 0;
        } else {
            this.population = Integer.parseInt(ageText);
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("%s %s (%d)", this.name, this.country, this.population);
    }
}

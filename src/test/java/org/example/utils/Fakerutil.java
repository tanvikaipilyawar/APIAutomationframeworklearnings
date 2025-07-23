package org.example.utils;

import com.github.javafaker.Faker;

public class Fakerutil {

    Faker faker= new Faker();
    public String GetFirstName(){
        return faker.name().firstName();
    }
    public String GetLastName(){
        return faker.name().lastName();
    }
}

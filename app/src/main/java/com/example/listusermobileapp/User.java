package com.example.listusermobileapp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private int age;
    private String name;
    private String family;
    private String country;
    private String city;
}

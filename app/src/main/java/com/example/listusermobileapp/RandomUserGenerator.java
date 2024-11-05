package com.example.listusermobileapp;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUserGenerator {
    private static final String[] NAMES = {"Аліна", "Олександр", "Софія", "Дмитро", "Марія", "Іван", "Тетяна", "Максим"};
    private static final String[] FAMILIES = {"Коваленко", "Шевченко", "Іваненко", "Петренко", "Тимошенко", "Гончаренко", "Кравченко", "Сидоренко"};
    private static final String[] CITIES = {"Київ", "Львів", "Одеса", "Харків", "Дніпро", "Запоріжжя", "Вінниця", "Чернівці"};
    private static final String[] COUNTRIES = {"Україна", "США", "Польща", "Німеччина", "Франція", "Італія", "Канада", "Австралія"};

    private Random random;

    public RandomUserGenerator() {
        this.random = new Random();
    }

    public User generateRandomUser() {
        String name = NAMES[random.nextInt(NAMES.length)];
        String family = FAMILIES[random.nextInt(FAMILIES.length)];
        int age = random.nextInt(60) + 18;
        String city = CITIES[random.nextInt(CITIES.length)];
        String country = COUNTRIES[random.nextInt(COUNTRIES.length)];
        int imageId = getRandomImageId();

        return new User(imageId, age, name, family, country, city);
    }

    public ArrayList<User> generateRandomUsers(int count) {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            userList.add(generateRandomUser());
        }
        return userList;
    }

    private int getRandomImageId() {
        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7};
        return images[random.nextInt(images.length)];
    }
}

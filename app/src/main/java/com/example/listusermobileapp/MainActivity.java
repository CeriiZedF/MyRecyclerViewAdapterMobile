package com.example.listusermobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> users = new ArrayList<>();
    RecyclerView recyclerView;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userAdapter = new UserAdapter(this, users);
        recyclerView.setAdapter(userAdapter);

        userAdapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user) {
                Toast.makeText(getApplicationContext(), "Обрано " + user.getName(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, User user) {
                Snackbar snackbar = Snackbar.make(view, "Видалити?", Snackbar.LENGTH_SHORT);
                snackbar.setTextColor(0XFF81C784);
                snackbar.setBackgroundTint(0XFF555555);
                snackbar.setActionTextColor(0XFF0277BD);
                snackbar.setAction("Так...", v -> {
                    userAdapter.remove(user);
                    Toast.makeText(getApplicationContext(),
                            user.getName() + " видалено",
                            Toast.LENGTH_SHORT).show();
                });
                snackbar.show();
            }
        });
    }

    private void setInitialData() {
        RandomUserGenerator userGenerator = new RandomUserGenerator();
        users = userGenerator.generateRandomUsers(100);
    }
}

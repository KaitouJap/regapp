package com.example.regapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListOfUsersActivity extends AppCompatActivity {
    private Button backButton;
    private ListView listView;
    private UsersAdapter usersAdapter;
    private List<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_of_users);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }

    public void init(){
        backButton = findViewById(R.id.backButton);
        listView = findViewById(R.id.listView);
        users = MainActivity.getUsers();
        usersAdapter = new UsersAdapter(users, ListOfUsersActivity.this);
        listView.setAdapter(usersAdapter);
    }
}
package com.example.regapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button registerButton;
    private Button listOfUsersButton;
    private static List<User> users;
    private TextInputLayout emailtTextInputLayout;
    private TextInputLayout passwordTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: ellenorzes, hogy nem ures a mezo
                String email = emailtTextInputLayout.getEditText().getText().toString();
                String password = passwordTextInputLayout.getEditText().getText().toString();
                users.add(new User(email, password));
                Toast.makeText(MainActivity.this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();

                //TODO: ellenorzes, hogy nem ures a mezo
                //emailtTextInputLayout.setError("Nem lehet ures");
            }
        });
        listOfUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListOfUsersActivity.class);
                startActivity(intent);
                //!!!!!!!!!!backstack ne legyen
                finish();
            }
        });
    }

    public void init(){
        registerButton = findViewById(R.id.registerButton);
        listOfUsersButton = findViewById(R.id.registeredUserListButton);
        emailtTextInputLayout = findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
        users = new ArrayList<>();
    }

    public static List<User> getUsers(){
        return users;
    }
}
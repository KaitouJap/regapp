package com.example.regapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends BaseAdapter {
    private List<User> users;
    private Context context;

    public UsersAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.users_list_items, parent, false);
        TextView email = convertView.findViewById(R.id.emailTextView);
        TextView password = convertView.findViewById(R.id.passwordTextView);
        email.setText(users.get(position).getEmail());
        password.setText(users.get(position).getPassword());
        return convertView;
    }
}

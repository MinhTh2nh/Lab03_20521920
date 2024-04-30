package com.example.hw_arrayadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, R.layout.item_user, users);
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        ViewHolder viewHolder; // ViewHolder pattern for efficient reusing of views

        if (convertView == null) {
            // Initialize the ViewHolder and set it as tag
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_user , parent , false);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvHome = convertView.findViewById(R.id.tvHome);

            convertView.setTag(viewHolder);
        } else {
            // Reuse the ViewHolder from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the user data to views
        viewHolder.tvName.setText(user.getName());
        viewHolder.tvHome.setText("from " + user.getHometown());

        return convertView;
    }

    // ViewHolder pattern for efficient reusing of views
    private static class ViewHolder {
        TextView tvName;
        TextView tvHome;
    }
}

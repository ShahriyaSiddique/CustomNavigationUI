package com.foresight.customnavigationui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class DrawerListAdapter extends ArrayAdapter {
    Context context;
    int layoutId;
    List<String> data = new ArrayList<>();
    public DrawerListAdapter(MainActivity mainActivity, int item, List<String> navItem) {
        super(mainActivity,item,navItem);
        this.context = mainActivity;
        this.layoutId = item;
        this.data = navItem;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        view = inflater.inflate(layoutId,parent,false);

        TextView tv = view.findViewById(R.id.nav_item);
        tv.setText(data.get(position));
        return view;
    }
}

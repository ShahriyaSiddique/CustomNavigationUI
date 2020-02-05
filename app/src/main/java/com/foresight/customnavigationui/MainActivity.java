package com.foresight.customnavigationui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import 	androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    ListView listView;
    ActionBarDrawerToggle t;
    String[] mNavTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFields();

        List<String> navItem = new ArrayList<>();
        navItem.add("DashBoard");
        navItem.add("Event");
        navItem.add("Lead");
        navItem.add("Status");
        navItem.add("Manage Team");
        navItem.add("Member List");

        DrawerListAdapter adapter = new DrawerListAdapter(this,R.layout.item,navItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                getSupportActionBar().setTitle(mNavTittle[position]);
                //select(position);
            }
        });

    }


    private void initializeFields() {
        drawer = findViewById(R.id.drawer);
        listView = findViewById(R.id.list_view);

        /* open/close of the drawer*/
        t = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.setDrawerListener(t);
        t.syncState();

        /* for nav button*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /* String from strings folder*/
        mNavTittle = getResources().getStringArray(R.array.nav_items);
    }

    private void select(int position) {

        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new BlankFragment();
                break;
            case 1:
                fragment = new BlankFragment2();
                break;
        }
        if (fragment!=null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();

            listView.setItemChecked(position,true);
            listView.setSelection(position);

            drawer.closeDrawer(listView);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}

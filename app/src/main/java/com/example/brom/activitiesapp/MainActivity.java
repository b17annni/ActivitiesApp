package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Create a ListView as in previous assignment
        List<String> listData = new ArrayList<String>(Arrays.asList(mountainNames));

        // 3. Create an ArrayAdapter object that connects
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_textview,R.id.my_item_textview,listData);

        ListView myListView = (ListView)findViewById(R.id.my_ListView);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // INTENT
                Intent intent = new Intent(getApplicationContext(), MountainDetailsActivity.class);
                intent.putExtra("mountainLocations", mountainLocations[position]);

                intent.putExtra("mountainNames", mountainNames[position]);
                int heights = mountainHeights[position];
                String mountainHeights = Integer.toString(heights);
                intent.putExtra("mountainHeights", mountainHeights);
                startActivity(intent);
            }
        });

        myListView.setAdapter(adapter);
    }
}

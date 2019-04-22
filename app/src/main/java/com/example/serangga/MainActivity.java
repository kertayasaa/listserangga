package com.example.serangga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Serangga> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(SeranggaData.getListData());
        showRecyclerList();

    }


    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListSeranggaAdapter listSeranggaAdapter = new ListSeranggaAdapter(this);
        listSeranggaAdapter.setListSerangga(list);
        rvCategory.setAdapter(listSeranggaAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridSeranggaAdapter gridSeranggaAdapter = new GridSeranggaAdapter(this);
        gridSeranggaAdapter.setListSerangga(list);
        rvCategory.setAdapter(gridSeranggaAdapter);
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewSeranggaAdapter cardViewSeranggaAdapter = new CardViewSeranggaAdapter(this);
        cardViewSeranggaAdapter.setListSerangga(list);
        rvCategory.setAdapter(cardViewSeranggaAdapter);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                setActionBarTitle("Mode List");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setActionBarTitle("Mode Grid");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("Mode CardView");
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

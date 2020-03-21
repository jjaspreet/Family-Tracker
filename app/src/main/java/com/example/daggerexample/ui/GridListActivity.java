package com.example.daggerexample.ui;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerexample.BaseActivity;
import com.example.daggerexample.R;
import com.example.daggerexample.data.Person;

import java.util.ArrayList;
import java.util.List;

public class GridListActivity extends BaseActivity {

    private TitleViewAdapter adapter;
    private RecyclerView recyclerView;
    private List<Person> personList = new ArrayList<>();

    @Override
    public int getLayoutResource() {
        return R.layout.activity_grid_list;
    }

    @Override
    protected void initViews() {

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        personList.add(new Person("Jaspreet", "Engineer"));
        personList.add(new Person("Manpreet", "Engineer"));
        personList.add(new Person("Harkirat", "Engineer"));

        adapter = new TitleViewAdapter(this, personList, new TitleViewAdapter.OnItemTouchedListener() {
            @Override
            public void onitemClicked(int position) {
                Intent intent = new Intent(GridListActivity.this, TabViewActivity.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        }


        );
        recyclerView.setAdapter(adapter);





    }

    @Override
    protected void handlerClicks() {

    }
}

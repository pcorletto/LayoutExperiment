package com.example.android.layoutexperiment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RecyclerView landscapeList;
    private List<Landscape> landscapes;

    private Toolbar toolbar;
    private Spinner spinner;
    String[] values = {"Value 1", "Value 2", "Value 3"};
    ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        landscapeList = (RecyclerView) findViewById(R.id.rvLandscapes);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        landscapeList.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

        toolbar.setNavigationIcon(R.drawable.ic_hamburger);
        getSupportActionBar().setTitle("Title");
        toolbar.setSubtitle("Subtitle");

        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                values);
        spinner.setAdapter(spinnerAdapter);

        placeFAB();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Hamburger pressed. I will add a menu here", Toast.LENGTH_LONG).show();



            }
        });

    }

    public void placeFAB(){

        FloatingActionButton myFAB = (FloatingActionButton) findViewById(R.id.myFAB);

        myFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked me!", Toast.LENGTH_LONG).show();

            }
        });


    }

    public void initializeData(){

        landscapes = new ArrayList<>();
        landscapes.add(new Landscape(R.drawable.landscape,"Morning Landscape"));
        landscapes.add(new Landscape(R.drawable.afternoon,"Afternoon Landscape"));
        landscapes.add(new Landscape(R.drawable.night,"Night Landscape"));
        landscapes.add(new Landscape(R.drawable.koala,"Koala"));
        landscapes.add(new Landscape(R.drawable.penguins,"Penguins"));
        landscapes.add(new Landscape(R.drawable.pelican,"Pelican"));
        landscapes.add(new Landscape(R.drawable.sealion,"Sea Lion"));
        landscapes.add(new Landscape(R.drawable.seaturtle,"Sea Turtle"));

    }

    public LandscapeAdapter adapter;

    private void initializeAdapter(){

        adapter = new LandscapeAdapter(landscapes);
        landscapeList.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        switch(id) {

            //noinspection SimplifiableIfStatement
            case R.id.action_settings:

            {
                Toast.makeText(MainActivity.this, "Settings pressed!", Toast.LENGTH_LONG).show();
                return true;

            }
            case R.id.action_search:
            {

                Toast.makeText(MainActivity.this, "Search button pressed!", Toast.LENGTH_LONG).show();
                return true;

            }

            case R.id.action_user:

            {

                Toast.makeText(MainActivity.this, "User button pressed!", Toast.LENGTH_LONG).show();
                return true;
            }

            case R.id.action_stuff:

            {

                Toast.makeText(MainActivity.this, "Cool cool cool!", Toast.LENGTH_LONG).show();
                return true;
            }


            default:

            return super.onOptionsItemSelected(item);

        }
    }
}

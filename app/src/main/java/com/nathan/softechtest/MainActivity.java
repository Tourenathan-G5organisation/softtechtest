package com.nathan.softechtest;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.nathan.softechtest.model.Doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mDoctorsAvailableList;
    private Adapter mListAdapter;
    private ImageView mProfileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        mProfileImage = findViewById(R.id.imageView);
        Glide
                .with(mProfileImage)
                .load(R.drawable.bessem)
                .circleCrop()
                .into(mProfileImage);

        mListAdapter = new Adapter();
        mDoctorsAvailableList = findViewById(R.id.recyclerView);
        mDoctorsAvailableList.setAdapter(mListAdapter);
        mDoctorsAvailableList.setNestedScrollingEnabled(false);
        mListAdapter.updateContent(getMockData());

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    List<Doctor> getMockData(){
        List<Doctor> data = new ArrayList<>();
        data.add(new Doctor("Dr Ndumbe", "Cardiologist", "R.drawable.doctor_sample"));
        data.add(new Doctor("Dr Ayuk", "Dentist", "R.drawable.doctor_sample"));
        data.add(new Doctor("Dr Verra", "Generalist", "R.drawable.doctor_sample"));
        data.add(new Doctor("Caro MD", "Heart surgeon", "R.drawable.doctor_sample"));

        return data;
    }
}
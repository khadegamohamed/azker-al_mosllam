package com.example.azkeral_moslam;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class first extends AppCompatActivity {
BottomNavigationView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
 bottom = findViewById(R.id.bottom_nav);
 bottom.setOnItemSelectedListener(navlisener);

 getSupportFragmentManager().beginTransaction().replace(R.id.contener,new praystime()).commit();

    }
    private NavigationBarView.OnItemSelectedListener navlisener = new NavigationBarView.OnItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectitem= null;
            switch (item.getItemId()){
                case R.id.Fragment1:
                  selectitem =  new praystime();
                    break;
                case  R.id.Fragment2:
                    selectitem = new AL_AZKER();
                    break;

            }
getSupportFragmentManager().beginTransaction().replace(R.id.contener,selectitem).commit();


            return true;
        }
    };
}
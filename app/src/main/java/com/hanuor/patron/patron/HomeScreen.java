package com.hanuor.patron.patron;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hanuor.patron.Adapters.RealmRecycler;
import com.hanuor.patron.R;

import java.util.ArrayList;

/**
 * Created by Shantanu Johri on 20-07-2016.
 */
public class HomeScreen extends AppCompatActivity {
    //KenBurnsView kbv;
   // private GridLayoutManager lLayout;
    ArrayList<String> arr;

    RecyclerView rView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);


        //Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        /*setSupportActionBar(topToolBar);
        topToolBar.setLogo(R.drawable.logo);
        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));
*/
        arr = new ArrayList<String>();
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");
        arr.add("Vamos");arr.add("Vamos");
        arr.add("Vamos");
        rView = (RecyclerView)findViewById(R.id.rlist);

        RecyclerView.LayoutManager lLayout = new GridLayoutManager(HomeScreen.this, 2);

        LinearLayoutManager llm = new LinearLayoutManager(HomeScreen.this);
        rView.setLayoutManager(lLayout);

        RealmRecycler rcAdapter = new RealmRecycler(HomeScreen.this, arr);
        rView.setAdapter(rcAdapter);
    }




}

package com.example.animelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AllAnimeActivity extends AppCompatActivity {
    private animeRecViewAdapter adapter;
    private RecyclerView animeRecView;
    private ImageView mainPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_anime);

        //overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        animeRecView = findViewById(R.id.animeRecView);
        mainPage = findViewById(R.id.mainPage);
        adapter = new animeRecViewAdapter(this,"AllAnimeActivity");

        animeRecView.setAdapter(adapter);
        animeRecView.setLayoutManager(new LinearLayoutManager(this));


        adapter.setAnime(Utils.getInstance().getAList());
        Glide.with(this).asBitmap().load("https://wallpapercave.com/wp/wp4741403.jpg").into(mainPage);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
//    }
}
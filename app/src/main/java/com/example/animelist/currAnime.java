package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class currAnime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curr_anime);

        ImageView imageView = findViewById(R.id.currPage);
        RecyclerView recView = findViewById(R.id.currRView);
        animeRecViewAdapter adapter = new animeRecViewAdapter(this,"currAnime");
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setAnime(Utils.getACurrList());
        Glide.with(this).asBitmap().load("https://wallpapercave.com/wp/wp5943374.jpg").into(imageView);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
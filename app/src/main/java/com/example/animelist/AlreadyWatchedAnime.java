package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AlreadyWatchedAnime extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_watched_anime);

        RecyclerView recView = findViewById(R.id.aRecView);
        animeRecViewAdapter adapter = new animeRecViewAdapter(this,"AlreadyWatchedAnime");
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setAnime(Utils.getAWatchedList());
        ImageView imageView = findViewById(R.id.compPage);
        Glide.with(this).asBitmap().load("https://i.pinimg.com/originals/c4/74/cd/c474cda1a6c2f4926b83c42c8a12deb6.jpg").into(imageView);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class wantToWatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_watch);

        RecyclerView recView = findViewById(R.id.arView);
        animeRecViewAdapter adapter = new animeRecViewAdapter(this,"wantToWatch");
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setAnime(Utils.getAWantList());
        ImageView imageView = findViewById(R.id.wantPage);
        Glide.with(this).asBitmap().load("https://i.pinimg.com/originals/c4/74/cd/c474cda1a6c2f4926b83c42c8a12deb6.jpg").into(imageView);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
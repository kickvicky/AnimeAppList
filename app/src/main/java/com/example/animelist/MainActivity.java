package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Button allAnime,watchingAnime,watchedAnime,wishlist,favorites,about;
    private ImageView logo;
    private ImageView entryPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initValues();
        allAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllAnimeActivity.class);
                startActivity(intent);
            }
        });

        watchedAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyWatchedAnime.class);
                startActivity(intent);

            }
        });

        watchingAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,currAnime.class);
                startActivity(intent);
            }
        });

        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,wantToWatch.class);
                startActivity(intent);
            }
        });

        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,favAnime.class);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Designed and Developed by Vignesh @ MIT\n" + "Check Out My Instagram:");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Link.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });


        Utils.getInstance();
    }
    private void initValues(){
        allAnime = findViewById(R.id.allAnime);
        watchingAnime = findViewById(R.id.watchingAnime);
        watchedAnime = findViewById(R.id.watchedAnime);
        wishlist = findViewById(R.id.wishlist);
        favorites = findViewById(R.id.favorites);
        about = findViewById(R.id.about);
        logo = findViewById(R.id.logo);
        entryPage = findViewById(R.id.entryPage);
        Glide.with(this).asBitmap().load("https://uploads.turbologo.com/uploads/design/preview_image/4551835/preview_image20210514-11995-1nv34jy.png").into(logo);
        //Glide.with(this).asBitmap().load("https://i.pinimg.com/originals/85/af/4d/85af4dd573d58658e8bcc44877273449.jpg").into(entryPage);
    }

}
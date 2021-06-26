package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AnimeActivity extends AppCompatActivity {

    private static final String ANIME_ID = "id";
    private ImageView animeLogo;
    private Button cWatching,wWacth,fav,completed;
    private TextView nameAnime,nameAuth,episodes,descShort,longDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        initValues();

        Intent intent = getIntent();
        if(null!=intent){
            int id = intent.getIntExtra(ANIME_ID,-1);
            if(id!=-1){
                Anime incomingAnime = Utils.getInstance().getAnimeByID(id);
                if(null!=incomingAnime){
                    setData(incomingAnime);
                    handleWatched(incomingAnime);
                    handleWishlist(incomingAnime);
                    handleFav(incomingAnime);
                    handleCurr(incomingAnime);
                }
            }
        }
    }
    //MULTIPLE FLAGS
    private void handleWishlist(final Anime aList){
        ArrayList<Anime> wantToAnime = Utils.getInstance().getAWantList();
        boolean flag = false;

        for(Anime a:wantToAnime){
            if(a.getId()==aList.getId()){
                flag=true;
            }
        }
        if(flag){
            wWacth.setEnabled(false);
        }
        else{
            wWacth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!Utils.getInstance().wantToWatch(aList))
                        Toast.makeText(AnimeActivity.this, "OOPS", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(AnimeActivity.this, "Anime Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AnimeActivity.this,wantToWatch.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    private void handleWatched(final Anime aList){
        ArrayList<Anime> watchedAnime = Utils.getInstance().getAWatchedList();
        boolean flag = false;

        for(Anime a:watchedAnime){
            if(a.getId()==aList.getId()){
                flag=true;
            }
        }
        if(flag){
            completed.setEnabled(false);
        }
        else{
            completed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToCompleted(aList)){
                        Toast.makeText(AnimeActivity.this, "Anime Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AnimeActivity.this,AlreadyWatchedAnime.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(AnimeActivity.this, "OOPS", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFav(final Anime aList){
        ArrayList<Anime> favAnime = Utils.getInstance().getAFavList();
        boolean flag = false;

        for(Anime a:favAnime){
            if(a.getId()==aList.getId()){
                flag=true;
            }
        }
        if(flag){
            fav.setEnabled(false);
        }
        else{
            fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().favList(aList)){
                        Toast.makeText(AnimeActivity.this, "Anime Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AnimeActivity.this,favAnime.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(AnimeActivity.this, "OOPS", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurr(final Anime aList){
        ArrayList<Anime> currAnime = Utils.getInstance().getACurrList();
        boolean flag = false;

        for(Anime a:currAnime){
            if(a.getId()==aList.getId()){
                flag=true;
            }
        }
        if(flag){
            cWatching.setEnabled(false);
        }
        else{
            cWatching.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().currList(aList)){
                        Toast.makeText(AnimeActivity.this, "Anime Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AnimeActivity.this,currAnime.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(AnimeActivity.this, "OOPS", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Anime aList){
        nameAnime.setText(aList.getName());
        nameAuth.setText(aList.getAuthor());
        episodes.setText(String.valueOf(aList.getEpisodes()));
        descShort.setText(aList.getShortDesc());
        longDesc.setText(aList.getLongDesc());
        Glide.with(this).asBitmap().load(aList.getImageUrl()).into(animeLogo);

    }

    private void initValues(){
        animeLogo = findViewById(R.id.animeLogo);
        cWatching = findViewById(R.id.cWatching);
        wWacth = findViewById(R.id.wWacth);
        completed = findViewById(R.id.completed);
        fav = findViewById(R.id.fav);
        nameAnime = findViewById(R.id.nameAnime);
        nameAuth = findViewById(R.id.nameAuth);
        episodes = findViewById(R.id.episodes);
        longDesc = findViewById(R.id.longDesc);
        descShort = findViewById(R.id.descShort);
    }
}